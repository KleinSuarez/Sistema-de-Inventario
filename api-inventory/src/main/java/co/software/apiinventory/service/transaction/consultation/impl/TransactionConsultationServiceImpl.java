package co.software.apiinventory.service.transaction.consultation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Transaction;
import co.software.apiinventory.repository.control.ControlRepository;
import co.software.apiinventory.service.transaction.consultation.TransactionConsultationService;

@Service
public class TransactionConsultationServiceImpl implements TransactionConsultationService{

	@Autowired
	private ControlRepository controlRepository;
	
	@Override
	public Iterable<Transaction> listAllTransactions(){
		return controlRepository.findAll();
	}
}
