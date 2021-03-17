package co.software.inventory.service.product.impl;

import java.util.List;
import co.software.inventory.model.Product;
import co.software.inventory.repository.ProductRepository;
import co.software.inventory.service.product.ConsultationPoductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationProductServiceImpl implements ConsultationPoductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return null;
	}

	@Override
	public Product findByReference() {
		return null;
	}
}
