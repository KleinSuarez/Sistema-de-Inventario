package co.software.apiinventory.command.product.modification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.product.modification.InventoryModificationService;

@RestController
@RequestMapping(value = "/v1/inventory/")
@CrossOrigin(origins = "*", methods = {RequestMethod.PUT})
public class ControllerModificationProduct {

	@Autowired
	private InventoryModificationService inventoryModificationService;

	@PostMapping("product/{idProduct}/update")
	public void insert(@PathVariable("idProduct") Integer idProduct, @RequestBody Product product) {
		inventoryModificationService.update(idProduct,product);
	}
}
