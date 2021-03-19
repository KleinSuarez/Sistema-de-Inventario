package co.software.apiinventory.consultation.controller.productType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.service.productType.consultation.ConsultationProductTypeService;

@RestController
@RequestMapping("/v1")
public class ControllerConsultationProductType {
	
	@Autowired
	private ConsultationProductTypeService consultationProductTypeService;
	
	@GetMapping("/product-types")
	Iterable<ProductType> findAll(){
		return consultationProductTypeService.findAll();
	}
}
