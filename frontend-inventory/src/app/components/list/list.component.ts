import { ProductService } from '../../services/product/product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product/product';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { ProductCommand } from 'src/app/command/product-command';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  productList: Product[] = [];
  showmodal: boolean;
  productInfo: Product;
  commandProduct: ProductCommand;

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    if (sessionStorage.getItem('user') == null) {
      this.router.navigate(['/login'])
    }
    this.showmodal = false;
    // tslint:disable-next-line: deprecation
    this.productService.listAllProducts().subscribe(
      res => {
        this.productList = res;
        console.log(this.productList)
        if (this.productList.length === 0) {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'It has not been possible to retrieve the information from the database',
            footer: '<a href>if the problem persists contact us</a>'
          });
        }
      }
    );
  }

  productUpdateStock(stock: any): void {
    console.log(stock)
    if (stock.outstock === undefined && stock.instock === undefined) {
      Swal.fire({
        title: 'Update Stock '+this.productInfo.productName,
        text: "empty fields, please fill them",
        icon: 'warning'
      })
    } else {
      let out: number = stock.outstock === undefined || null ? 0 : stock.outstock
      let ins: number = stock.instock === undefined || null ? 0 : stock.instock
      let nStock: number = this.productInfo.stock - Number(out) + Number(ins)
      if (nStock < 0) {
        Swal.fire({
          title: 'Update Stock '+this.productInfo.productName,
          text: "insufficient stock for the operation",
          icon: 'warning'
        })
      } else {
        this.setupCommand(nStock)
        this.productService.updateStock(this.commandProduct, ins, out).subscribe(
          res => {
            Swal.fire('Updated', '', 'success')
            this.showmodal = false;

            window.location.reload()
          }
        )
      }
    }
  }

  setupCommand(newStock): void {
    this.commandProduct = new ProductCommand();
    this.commandProduct.idProduct = this.productInfo.idProduct;
    this.commandProduct.reference = this.productInfo.reference;
    this.commandProduct.productName = this.productInfo.productName;
    this.commandProduct.stock = newStock;
    this.commandProduct.idProductType = this.productInfo.productType.idProductType;
    this.commandProduct.active = this.productInfo.active;
  }

  productEdit(): void {
    this.router.navigate([`/update-product/${this.productInfo.idProduct}`])
  }

  deleteProduct(): void {
    Swal.fire({
      title: this.productInfo.productName,
      text: "¿Are you sure to remove the product?",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: "Yes, delete",
      cancelButtonText: "Cancel",
    }).then(
      res => {
        if (res.value) {
          this.setupCommand(0)
          this.productService.delete(this.commandProduct).subscribe();
          Swal.fire('Product removed successfully', '', 'info')
        }
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      }
    )
  }

  showModal(product: Product): void {
    this.showmodal = true;
    this.productInfo = product;
  }
}
