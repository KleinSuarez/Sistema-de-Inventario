import { ProductCommand } from './../command/product-command';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  endPoint = 'http://127.0.0.1:8081/v1/inventory/products';
  endPoint2 = 'http://127.0.0.1:8081/v1/inventory/product/insert';
  constructor(private http: HttpClient) { }

  listAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.endPoint);
  }

  insert(commandProduct: ProductCommand): Observable<Product> {
    return this.http.post<Product>(this.endPoint2, commandProduct, { headers: { 'content-type': 'application/json' } });
  }
}
