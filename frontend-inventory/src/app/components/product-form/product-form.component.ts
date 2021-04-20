import { ProductService } from './../../services/product.service';
import { ProductTypeService } from './../../services/product-type.service';
import { ProductType } from './../../model/product_type/product-type';
import { Component, OnInit } from '@angular/core';
import { ProductCommand } from 'src/app/command/product-command';
import { Product } from 'src/app/model/product/product';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  productTypeList: ProductType[] = [];
  product = new Product();
  commandProduct: ProductCommand;

  constructor(private productTypeServices: ProductTypeService,
    private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    // tslint:disable-next-line: deprecation
    this.productTypeServices.listProductType().subscribe(
      res => {
        this.productTypeList = res;
      }
    );
  }

  // tslint:disable-next-line: typedef
  insert() {
    Swal.fire({
      title: 'Do you want add product?',
      showDenyButton: true,
      showCancelButton: true,
      confirmButtonText: `Save`,
      denyButtonText: `Don't save`,
    }).then((result) => {
      /* Read more about isConfirmed, isDenied below */
      if (result.isConfirmed) {
        this.setupCommand();
        this.refValidator();
      } else if (result.isDenied) {
        Swal.fire('Product not saved', '', 'info');
      }
    });
  }

  refValidator(): void {
    if (this.productService.getProductByReference(this.commandProduct.reference)) {
      Swal.fire('product reference already exists', '', 'info');
    } else {
      this.saveProduct();
    }
  }

  saveProduct(): void {
    // tslint:disable-next-line: deprecation
    this.productService.insert(this.commandProduct).subscribe(
      res => {
        Swal.fire('Saved!', '', 'success');
        this.router.navigate(['/list-products']);
      }
    );
  }

  setupCommand(): void {
    console.log(this.product);
    this.commandProduct = new ProductCommand();
    this.commandProduct.idProduct = 0;
    this.commandProduct.reference = this.product.reference;
    this.commandProduct.productName = this.product.productName;
    this.commandProduct.stock = this.product.stock;
    this.commandProduct.idProductType = this.product.productType.idProductType;
  }
}

