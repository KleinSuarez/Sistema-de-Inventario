import { Product } from './product';

export class Transaction {
  idTransation: number;
  product: Product;
  addStock: number;
  outStock: number;
  modificationDate: string;
}
