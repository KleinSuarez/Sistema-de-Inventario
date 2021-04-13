package co.software.apiinventory.service.product.insertion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.insertion.ProductInsertionService;

@Service
public class ProductInsertionServiceImpl implements ProductInsertionService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Integer InsertProduct(Product product) {
		productRepository.save(product);
		return product.getIdProduct();
	}

}
