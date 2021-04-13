package co.software.apiinventory.service.product.consultation;

import java.util.List;

import co.software.apiinventory.model.Product;

public interface ProductConsultationService {

	List<Product> listAllProducts();
	Product findByReference(String reference);
	Product findById(Integer idProduct);
}
