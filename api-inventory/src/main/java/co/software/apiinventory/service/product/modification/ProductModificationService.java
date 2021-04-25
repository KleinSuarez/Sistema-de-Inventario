package co.software.apiinventory.service.product.modification;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.model.Product;

public interface InventoryModificationService {

	void update(Integer idProduct, ProductDTO productDTO);

}
