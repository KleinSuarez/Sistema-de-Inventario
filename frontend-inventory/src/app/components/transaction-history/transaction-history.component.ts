import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/model/transaction/transaction';
import { TransactionHistoryService } from 'src/app/services/transaction-history.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {

  transactionHistoryList: Transaction[] = []

  constructor(private transactionService: TransactionHistoryService) { }

  ngOnInit(): void {
    this.transactionService.getHistory().subscribe(
      res => {
        this.transactionHistoryList = res;
        if (this.transactionHistoryList.length === 0) {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'It has not been possible to retrieve the information from the database',
            footer: '<a href>contact IT if the problem persists</a>'
          });
        }
      }
    );
  }
}

