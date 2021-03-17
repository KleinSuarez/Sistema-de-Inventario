package co.software.inventory.service.product;

import java.util.List;

import co.software.inventory.model.Product;

public interface ConsultationPoductService {
	
	List<Product> findAll();
	
	Product findByReference();
}
