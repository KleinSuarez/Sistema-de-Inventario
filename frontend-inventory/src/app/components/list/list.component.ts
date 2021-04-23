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

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
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

  productEdit(product: Product): void {
    this.router.navigate([`/update-product/${product.idProduct}`])
  }

  deleteProduct(product: Product): void {
    Swal.fire({
        text: "¿Are you sure to remove the product?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: "Yes, delete",
        cancelButtonText: "Cancel",
    }).then(
      res => {
        if(res.value){
          this.productService.delete(product.idProduct).subscribe();
          Swal.fire('Product removed successfully', '', 'info')
        }
        setTimeout(() => {
          window.location.reload();
        }, 1000);
      }
    )


    
  }
}
