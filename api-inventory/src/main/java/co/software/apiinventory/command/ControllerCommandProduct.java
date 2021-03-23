package co.software.apiinventory.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.product.creation.CreationProductService;
import co.software.apiinventory.service.product.delete.DeleteProductService;
import co.software.apiinventory.service.product.update.UpdateProductService;

//@RestController
//@RequestMapping("/v1/product")
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,	RequestMethod.DELETE })
public class ControllerCommandProduct {

	@Autowired
	private CreationProductService creationProductService;
	@Autowired
	private UpdateProductService updateProductService;
	@Autowired
	private DeleteProductService deleteProductService;

	@PostMapping("/insert")
	public void insert(@RequestBody Product product) {
		creationProductService.insert(product);
	}

	@PutMapping("/update/{idProduct}")
	public void update(@PathVariable("idProduct") Integer idProduct, @RequestBody Product product) {
		updateProductService.updated(idProduct, product);
	}

	@DeleteMapping("deleted/{idProduct}")
	public void deleted(@PathVariable("idProduct") Integer idProduct) {
		deleteProductService.deleted(idProduct);
	}

}
