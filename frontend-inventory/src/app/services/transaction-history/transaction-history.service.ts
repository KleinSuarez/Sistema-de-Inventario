import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ConnectionParameters } from 'src/app/util/connection-parameters';
import { Transaction } from '../../model/transaction/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionHistoryService {
  endPoint = this.connectionParameters.getUrlBase().concat('history')
  constructor(private http: HttpClient, private connectionParameters: ConnectionParameters) { }

  getHistory(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.endPoint, { headers: this.connectionParameters.getSimpleHeader() });
  }
}
