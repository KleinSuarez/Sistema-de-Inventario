package co.software.inventory.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.software.inventory.model.Product;
import co.software.inventory.service.product.ConsultationPoductService;

@RestController
@RequestMapping("/v")
public class ControllerCommandProduct {
	@Autowired
	private ConsultationPoductService productService;
	
	@GetMapping("/products")
	List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/product/{reference}")
	Product findByReference(@PathVariable("reference") String reference) {
		return productService.findByReference();
	}
}
