package co.software.apiinventory.service.product.delete;

import co.software.apiinventory.model.Product;

public interface ProductDeleteService {

	Integer deleted(Integer idProduct, Product product);

}
