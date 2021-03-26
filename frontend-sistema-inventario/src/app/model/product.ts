import { ProductType } from './product-type';

export class Product {
  idProduct: number;
  reference: string;
  productName: string;
  productType: ProductType;
  stock: number;
}
