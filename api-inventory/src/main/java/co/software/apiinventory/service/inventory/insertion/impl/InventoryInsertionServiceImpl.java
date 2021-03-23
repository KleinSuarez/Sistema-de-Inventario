package co.software.apiinventory.service.inventory.insertion.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.inventory.InventoryRepository;
import co.software.apiinventory.service.inventory.insertion.InventoryInsertionService;

@Service
public class InventoryInsertionServiceImpl implements InventoryInsertionService{

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public void InsertProduct(Product product) {
		inventoryRepository.save(product);
		
	}

}
