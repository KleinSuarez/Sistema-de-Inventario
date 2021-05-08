package co.software.apiinventory.command.producttype.consultation;

import co.software.apiinventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.service.productType.consultation.ConsultationProductTypeService;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class ControllerConsultationProductType {
	
	@Autowired
	private ConsultationProductTypeService consultationProductTypeService;

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/product-types")
	Iterable<ProductType> findAll(){
		return consultationProductTypeService.findAll();
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/product-type/{idProductType}")
	ProductType findById(@PathVariable("idProductType") Integer idProductType) {
		return consultationProductTypeService.findById(idProductType);
	}
}
