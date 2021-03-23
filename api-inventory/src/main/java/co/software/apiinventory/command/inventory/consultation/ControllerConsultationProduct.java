package co.software.apiinventory.command.inventory.consultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.inventory.cosultation.InventoryConsultationService;

@RestController
@RequestMapping(value = "/v1/inventory/")
public class ControllerConsultationProduct {
	
	@Autowired
	private InventoryConsultationService invetoryConsultationService;

	@GetMapping("products")
	List<Product> listAllProducts() {
		
		return invetoryConsultationService.listAllProducts();
	}
	
}
