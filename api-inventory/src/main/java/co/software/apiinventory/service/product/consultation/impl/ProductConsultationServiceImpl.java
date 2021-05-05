package co.software.apiinventory.service.product.consultation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;

@Service
public class ProductConsultationServiceImpl implements ProductConsultationService {

	@Autowired
	private ProductRepository productRepository;

	// Returns the product list ordered in descending order by the available quantity
	@Override
	public List<Product> listAllProducts(){
		ArrayList<Product> products = (ArrayList<Product>) productRepository.findAll();
		Collections.sort(products, new Comparator<Product>() {
			public int compare (Product product1, Product product2) {
				return Integer.valueOf(product2.getStock()).compareTo(product1.getStock());
			}
		});
		return 	products;
	}

	@Override
	public Product findByReference(String reference) {
		Product product = new Product();
		for (Product productIterator: listAllProducts()) {
			if(productIterator.getReference().equals(reference)) {
				product = productIterator;
			}
		}
		return product;
	}

	@Override
	public Product findById(Integer idProduct) {
		return productRepository.findById(idProduct).orElse(null);
	}
}
