import { ProductType } from './../product_type/product-type';
export class Product {
  idProduct: number;
  reference: string;
  productName: string;
  stock: number;
  productType: ProductType;
  active: boolean;
}
