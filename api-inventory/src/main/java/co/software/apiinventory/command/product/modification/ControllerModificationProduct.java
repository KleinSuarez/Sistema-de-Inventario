package co.software.apiinventory.command.product.modification;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.command.handler.product.modification.ProductModificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/inventory/")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ControllerModificationProduct {

	@Autowired
	private ProductModificationHandler productModificationHandler;

	@PostMapping("product/{idProduct}/update")
	public void update(@PathVariable("idProduct") Integer idProduct, @RequestBody ProductDTO productDTO) {
		productDTO.setIdProduct(idProduct);
		productModificationHandler.execute(productDTO);
	}
}
