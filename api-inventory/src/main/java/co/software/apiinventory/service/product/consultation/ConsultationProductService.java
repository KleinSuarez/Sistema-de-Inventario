package co.software.apiinventory.service.product.consultation;

import co.software.apiinventory.model.Product;

public interface ConsultationProductService {

	Iterable<Product> findAll();

	Product findByReference(String reference);

	Product findById(Integer idProduct);

}
