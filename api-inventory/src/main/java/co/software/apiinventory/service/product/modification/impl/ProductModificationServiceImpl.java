package co.software.apiinventory.service.product.modification.impl;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.command.handler.product.insert.ProductInsertHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.modification.InventoryModificationService;

@Service
public class InventoryModificationServiceImpl implements InventoryModificationService{

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductInsertHandler productInsertHandler;
	
	@Override
	public void update(Integer idProduct, ProductDTO productDTO) {
		if (productRepository.existsById(idProduct)) {
			productDTO.setIdProduct(idProduct);
			Product productTemp = null;
			for (Product productIterable : productRepository.findAll()) {
				if(productIterable.getIdProduct() == idProduct) {
					productTemp = productIterable;
					break;
				}
			}

			productInsertHandler.execute(productDTO);
/*
			String reference = (product.getReference() == null)? productTemp.getReference(): product.getReference();
			String productName = (product.getProductName() == null)? productTemp.getProductName(): product.getProductName();
			int amount = (product.getStock()==0)? productTemp.getStock(): product.getStock();
			
			product.setProductType(new ProductType(product.getProductType().getIdProductType().equals(null)? productTemp.getProductType().getIdProductType(): product.getProductType().getIdProductType() , ""));

			
			product.setReference(reference);
			product.setProductName(productName);
			product.setStock(amount);
			productRepository.save(product);*/
			
		}else {
			//productRepository.save(product);
		}
		
	}

	
}
