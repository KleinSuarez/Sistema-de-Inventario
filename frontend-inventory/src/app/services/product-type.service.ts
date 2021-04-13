import { ProductType } from './../model/product_type/product-type';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {

  endPoint = 'http://127.0.0.1:8081/v1/product-types';
  constructor(private http: HttpClient) { }

  listProductType(): Observable<ProductType[]> {
    return this.http.get<ProductType[]>(this.endPoint);
  }
}
