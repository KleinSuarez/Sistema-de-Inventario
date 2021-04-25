package co.software.apiinventory.command.product.delete;

import co.software.apiinventory.domain.ExistenceValidator;
import co.software.apiinventory.domain.message.Message;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.service.product.delete.InventoryDeleteService;

@RestController
@RequestMapping(value = "/v1/inventory/")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
public class ControllerDeleteProduct {

	@Autowired
	private ProductConsultationService productConsultationService;

	@Autowired
	private InventoryDeleteService inventoryDeleteService;

	@DeleteMapping("product/{idProduct}/deleted")
	public void deletedProduct(@PathVariable("idProduct") Integer idProduct) {
		ExistenceValidator.existenceIdProduct(productConsultationService.findById(idProduct), Message.PRODUCT_DONT_EXIST);
		inventoryDeleteService.deleted(idProduct);
	}
}
