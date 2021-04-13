import { ProductTypeService } from './../../services/product-type.service';
import { ProductType } from './../../model/product_type/product-type';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-product-type',
  templateUrl: './list-product-type.component.html',
  styleUrls: ['./list-product-type.component.css']
})
export class ListProductTypeComponent implements OnInit {

  productTypeList: ProductType[] = [];

  constructor(private productTypeService: ProductTypeService) { }

  ngOnInit(): void {
    // tslint:disable-next-line: deprecation
    this.productTypeService.listProductType().subscribe(
      res => {
        this.productTypeList = res;
        if (this.productTypeList.length === 0) {
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
}
