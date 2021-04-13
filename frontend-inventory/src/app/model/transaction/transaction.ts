import { Product } from './../product/product';
export class Transaction {
  idTransation: number;
  inStock: number;
  outStock: number;
  modificationDate: string;
  product: Product;
}
