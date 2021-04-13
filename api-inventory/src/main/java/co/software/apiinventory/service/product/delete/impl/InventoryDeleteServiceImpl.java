package co.software.apiinventory.service.product.delete.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.delete.InventoryDeleteService;

@Service
public class InventoryDeleteServiceImpl implements InventoryDeleteService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void deleted(Integer idProduct) {
		productRepository.deleteById(idProduct);
	}

}
