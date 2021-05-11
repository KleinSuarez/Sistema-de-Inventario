import { ProductCommand } from '../../command/product-command';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../../model/product/product';
import { ConnectionParameters } from 'src/app/util/connection-parameters';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  endPoint = this.connectionParameters.getUrlBase().concat('v1/inventory/')

  constructor(private http: HttpClient, private connectionParameters: ConnectionParameters) { }

  listAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.endPoint.concat('products'), { headers: this.connectionParameters.getSimpleHeader()});
  }

  getProductByReference(reference: string): Observable<Product> {
    return this.http.get<Product>(
      this.endPoint.concat('product-by-reference/' + reference), { headers: this.connectionParameters.getSimpleHeader()});
  }

  getProductById(idProduct: number): Observable<Product> {
    return this.http.get<Product>(this.endPoint.concat('product-by-id/' + idProduct), { headers: this.connectionParameters.getSimpleHeader()});
  }

  insert(commandProduct: ProductCommand): Observable<Product> {
    return this.http.post<Product>(this.endPoint.concat('product/insert'), commandProduct, { headers: this.connectionParameters.getJsonHeader()});
  }

  delete(idProduct: number): Observable<Product> {
    return this.http.delete<Product>(this.endPoint.concat(`product/${idProduct}/deleted`), { headers: this.connectionParameters.getSimpleHeader()});
  }

  update(commandProduct: ProductCommand): Observable<Product> {
    return this.http.post<Product>(this.endPoint.concat('product/' + commandProduct.idProduct + '/update'), commandProduct, { headers: this.connectionParameters.getJsonHeader()});
  }

  updateStock(commandProduct: ProductCommand, instock: number, outstock: number): Observable<Product> {
    return this.http.post<Product>(this.endPoint.concat('product/' + commandProduct.idProduct + `/update-stock/${instock}/${outstock}/`), commandProduct,{ headers: this.connectionParameters.getJsonHeader()});
  }
}
