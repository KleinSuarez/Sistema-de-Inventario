package co.software.apiinventory.service.product.consultation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.consultation.ConsultationProductService;

@Service
public class ConsultationProductServiceImpl implements ConsultationProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Product findById(Integer idProduct) {
		return productRepository.findById(idProduct).orElse(null);
	}

	@Override
	public Product findByReference(String reference) {
		Iterable<Product> products = findAll();
		Product product = null;
		for (Product productIterator : products) {
			if(productIterator.getReference() == reference) {
				product = productIterator;
				break;
			}
		}
		return product;
	}

}
