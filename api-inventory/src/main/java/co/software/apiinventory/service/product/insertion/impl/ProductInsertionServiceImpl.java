package co.software.apiinventory.service.product.insertion.impl;

import co.software.apiinventory.model.Transaction;
import co.software.apiinventory.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.insertion.ProductInsertionService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProductInsertionServiceImpl implements ProductInsertionService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public Integer InsertProduct(Product product) {
		productRepository.save(product);
		transactionRepository.save(new Transaction(
				product,
				product.getStock(),
				0,
				new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
		return product.getIdProduct();
	}

}
