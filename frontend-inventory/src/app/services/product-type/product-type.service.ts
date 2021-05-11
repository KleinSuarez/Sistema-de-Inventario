import { ProductType } from '../../model/product_type/product-type';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ConnectionParameters } from 'src/app/util/connection-parameters';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {

  endPoint = this.connectionParameters.getUrlBase().concat('v1/product-types')

  constructor(private http: HttpClient, private connectionParameters : ConnectionParameters) { }

  listProductType(): Observable<ProductType[]> {
    return this.http.get<ProductType[]>(this.endPoint, {headers: this.connectionParameters.getSimpleHeader()});
  }
}
