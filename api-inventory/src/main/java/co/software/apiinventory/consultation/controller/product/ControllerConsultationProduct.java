package co.software.apiinventory.consultation.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.product.consultation.ConsultationProductService;

@RestController
@RequestMapping("/v1")
public class ControllerConsultationProduct {

	@Autowired
	private ConsultationProductService productService;

	@GetMapping("/products")
	Iterable<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/product/{reference}")
	Product findByReference(@PathVariable("reference") String reference) {
		return productService.findByReference(reference);
	}

	@GetMapping("/product-by-id/{idProduct}")
	Product findById(@PathVariable("idProduct") Integer idProduct) {
		return productService.findById(idProduct);
	}
}
