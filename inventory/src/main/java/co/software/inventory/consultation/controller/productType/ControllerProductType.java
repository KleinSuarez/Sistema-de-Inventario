package co.software.inventory.consultation.controller.productType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.software.inventory.model.ProductType;

@RestController
@RequestMapping("/v1/product-type")
public class ControllerProductType {
	
	Iterable<ProductType> findAll(){
		return null;
	}
}
