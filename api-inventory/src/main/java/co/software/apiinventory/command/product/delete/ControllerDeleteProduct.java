package co.software.apiinventory.command.product.delete;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.command.handler.product.modification.ProductModificationHandler;
import co.software.apiinventory.domain.ExistenceValidator;
import co.software.apiinventory.domain.message.Message;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/inventory/")
public class ControllerDeleteProduct {

	@Autowired
	private ProductConsultationService productConsultationService;

	@Autowired
	private ProductModificationHandler productModificationHandler;

	@Secured({"ROLE_ADMIN"})
	@PostMapping("product/{idProduct}/deleted")
	public void deletedProduct(@PathVariable("idProduct") Integer idProduct, @RequestBody ProductDTO productDTO) {
		ExistenceValidator.existenceIdProduct(productConsultationService.findById(idProduct), Message.PRODUCT_DONT_EXIST);
		productDTO.setIdProduct(idProduct);
		productDTO.setActive(false);

		productModificationHandler.execute(productDTO);
	}
}
