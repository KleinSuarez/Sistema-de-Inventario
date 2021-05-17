package co.software.apiinventory.service.product.delete.impl;

import co.software.apiinventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.delete.ProductDeleteService;

@Service
public class ProductDeleteServiceImpl implements ProductDeleteService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Integer deleted(Integer idProduct,Product product) {
		productRepository.save(product);
		return product.getIdProduct();
	}
}
