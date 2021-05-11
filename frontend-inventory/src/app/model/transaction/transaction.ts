import { Product } from './../product/product';
export class Transaction {
  idTransaction: number;
  inStock: number;
  outStock: number;
  modificationDate: string;
  product: Product;
}
