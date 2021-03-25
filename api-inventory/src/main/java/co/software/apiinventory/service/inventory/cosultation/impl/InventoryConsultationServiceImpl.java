package co.software.apiinventory.service.inventory.cosultation.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.inventory.InventoryRepository;
import co.software.apiinventory.service.inventory.cosultation.InventoryConsultationService;

@Service
public class InventoryConsultationServiceImpl implements InventoryConsultationService{

	@Autowired
	private InventoryRepository inventoryRepository;

	//Returns the product list ordered in descending order by the available quantity
	@Override
	public List<Product> listAllProducts(){
		ArrayList<Product> products = (ArrayList<Product>) inventoryRepository.findAll();
		Collections.sort(products, new Comparator<Product>() {
			public int compare (Product product1, Product product2) {
				return Integer.valueOf(product2.getStock()).compareTo(product1.getStock());
			}
		});
		return 	products;
	}
}
