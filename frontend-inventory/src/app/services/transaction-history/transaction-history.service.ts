import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from '../../model/transaction/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionHistoryService {
  endPoint = 'http://127.0.0.1:8081/history';
  constructor(private http: HttpClient) { }

  getHistory(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.endPoint);
  }
}
