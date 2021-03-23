package co.software.apiinventory.command.inventory.create;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.inventory.insertion.InventoryInsertionService;

@RestController
@RequestMapping(value = "/v1/inventory/")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ControllerInsertionProduct {

	@Autowired
	private InventoryInsertionService inventoryInsertionService;

	@PostMapping("product/insert")
	public void insert(@RequestBody Product product) {
		inventoryInsertionService.InsertProduct(product);
	}
		
}
