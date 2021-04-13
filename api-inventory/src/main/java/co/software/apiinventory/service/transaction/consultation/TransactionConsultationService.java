package co.software.apiinventory.service.transaction.consultation;

import co.software.apiinventory.model.Transaction;

public interface TransactionConsultationService {

	Iterable<Transaction> listAllTransactions();

}
