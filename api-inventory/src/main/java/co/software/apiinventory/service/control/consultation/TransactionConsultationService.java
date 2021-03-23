package co.software.apiinventory.service.control.consultation;

import co.software.apiinventory.model.Transaction;

public interface TransactionConsultationService {

	Iterable<Transaction> listAllTransactions();

}
