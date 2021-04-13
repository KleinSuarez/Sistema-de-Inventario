package co.software.apiinventory.command.product.create;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.command.handler.product.insert.ProductInsertHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Product;

@RestController
@RequestMapping(value = "/v1/inventory/")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ControllerInsertionProduct {

	@Autowired
	private ProductInsertHandler productInsertHandler;

	@PostMapping("product/insert")
	public void insert(@RequestBody ProductDTO productDTO) {
		productInsertHandler.execute(productDTO);
	}
		
}
