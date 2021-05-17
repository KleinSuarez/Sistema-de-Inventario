import { ProductService } from '../../services/product/product.service';
import { ProductTypeService } from '../../services/product-type/product-type.service';
import { ProductType } from './../../model/product_type/product-type';
import { Component, OnInit } from '@angular/core';
import { ProductCommand } from 'src/app/command/product-command';
import { Product } from 'src/app/model/product/product';
import Swal from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  productTypeList: ProductType[] = [];
  product = new Product();
  commandProduct: ProductCommand;
  idProduct: number;
  productTemp = new Product();

  constructor(private productTypeServices: ProductTypeService,
    private productService: ProductService,
    private router: Router, private route: ActivatedRoute) {
    this.idProduct = + this.route.snapshot.paramMap.get('idProduct');
    if (this.idProduct !== 0) {
      this.productByID();
    }
  }

  ngOnInit(): void {
    if(sessionStorage.getItem('user') == null){
      this.router.navigate(['/login'])
    }
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
      this.setupCommand();
      if (result.isConfirmed) {
        if (this.commandProduct.idProduct !== 0 && this.commandProduct.idProduct !== undefined) {
          this.updateProduct();
        } else {
          this.refValidator();
        }
      } else if (result.isDenied) {
        Swal.fire('Product not saved', '', 'info');
      }
    });
  }

  refValidator(): void {
    this.productService.getProductByReference(this.commandProduct.reference).subscribe(
      res => {
        this.productTemp = res
        if (this.productTemp.reference !== null || this.productTemp.reference === undefined) {
          Swal.fire('product reference already exists', '', 'info');
        } else {
          this.saveProduct();
        }
      }
    );
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
    this.commandProduct = new ProductCommand();
    this.commandProduct.idProduct = this.product.idProduct;
    this.commandProduct.reference = this.product.reference;
    this.commandProduct.productName = this.product.productName;
    this.commandProduct.stock = this.product.stock;
    this.commandProduct.idProductType = this.product.productType.idProductType;
    this.commandProduct.active = this.product.active
    console.log(this.product.active)
  }

  productByID(): void {
    this.productService.getProductById(this.idProduct).subscribe(
      res => {
        this.product = res;
      }
    );
  }

  updateProduct(): void {
    this.productService.update(this.commandProduct).subscribe(
      res => {
        Swal.fire('Updated', '', 'success')

        this.router.navigate(['/list-products']);
      }
    )
  }

  selectTypeProduct(productType: ProductType, productType2: ProductType): boolean {
    if (productType == null || productType2 == null) {
      return false;
    }
    return productType.idProductType === productType2.idProductType;
  }
}

