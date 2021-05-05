package co.software.apiinventory.command.product.consultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;

@RestController
@RequestMapping(value = "/v1/inventory/")
public class ControllerConsultationProduct {
	
	@Autowired
	private ProductConsultationService productConsultationService;

	@Secured({"ROLE_ADMIN"})
	@GetMapping("products")
	List<Product> listAllProducts() {
		return productConsultationService.listAllProducts();
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("product-by-id/{idProduct}")
	Product findById(@PathVariable("idProduct") Integer idProduct) {
		return productConsultationService.findById(idProduct);
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("product-by-reference/{reference}")
	Product findByReference(@PathVariable ("reference") String reference){
		return productConsultationService.findByReference(reference);
	}

}
