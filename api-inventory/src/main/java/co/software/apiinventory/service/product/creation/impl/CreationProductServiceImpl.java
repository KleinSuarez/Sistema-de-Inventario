package co.software.apiinventory.service.product.creation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.creation.CreationProductService;

//@Service
public class CreationProductServiceImpl implements CreationProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void insert(Product product) {
		productRepository.save(product);
	}	
}
