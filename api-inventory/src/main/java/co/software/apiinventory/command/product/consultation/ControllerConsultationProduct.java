package co.software.apiinventory.command.product.consultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;

@RestController
@RequestMapping(value = "/v1/inventory/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ControllerConsultationProduct {
	
	@Autowired
	private ProductConsultationService productConsultationService;

	@GetMapping("products")
	List<Product> listAllProducts() {
		return productConsultationService.listAllProducts();
	}

	@GetMapping("/product-by-id/{idProduct}")
	Product findById(@PathVariable("idProduct") Integer idProduct) {
		return productConsultationService.findById(idProduct);
	}

	@GetMapping("product-by-reference/{reference}")
	Product findByReference(@PathVariable ("reference") String reference){
		return productConsultationService.findByReference(reference);
	}

}
