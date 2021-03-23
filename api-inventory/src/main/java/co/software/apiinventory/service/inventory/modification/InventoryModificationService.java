package co.software.apiinventory.service.inventory.modification;

import co.software.apiinventory.model.Product;

public interface InventoryModificationService {

	void update(Integer idProduct, Product product);

}
