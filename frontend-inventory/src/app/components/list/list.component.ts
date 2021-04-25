import { ProductService } from './../../services/product.service';
import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product/product';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  productList: Product[] = [];
  showmodal: boolean;
  productInfo: Product;

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {

    this.showmodal = false;
    // tslint:disable-next-line: deprecation
    this.productService.listAllProducts().subscribe(
      res => {
        this.productList = res;
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
          this.productService.delete(this.productInfo.idProduct).subscribe();
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
    console.log(product)
  }
}
