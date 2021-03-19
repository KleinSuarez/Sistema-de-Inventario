package co.software.apiinventory.service.product.delete.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.delete.DeleteProductService;

@Service
public class DeleteProductServiceImpl implements DeleteProductService{

	@Autowired
	private ProductRepository productRepository;
	
	public void deleted(Integer idProduct) {
		productRepository.deleteById(idProduct);
	}
}
