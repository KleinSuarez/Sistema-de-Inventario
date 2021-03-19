package co.software.apiinventory.service.product.update.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.update.UpdateProductService;

@Service
public class UpdateProductServiceImpl implements UpdateProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void updated(Integer idProduct, Product product) {
		if (productRepository.existsById(idProduct)) {
			product.setIdProduct(idProduct);
			Product productTemp = null;
			for (Product productIterable : productRepository.findAll()) {
				if(productIterable.getIdProduct() == idProduct) {
					productTemp = productIterable;
					break;
				}
			}

			
			String reference = (product.getReference() == null)? productTemp.getReference(): product.getReference();
			String productName = (product.getProductName() == null)? productTemp.getProductName(): product.getProductName();
			int amount = (product.getAmount()==0)? productTemp.getAmount(): product.getAmount();
			
			product.setProductType(new ProductType(product.getProductType().getIdProductType().equals(null)? productTemp.getProductType().getIdProductType(): product.getProductType().getIdProductType() , ""));

			
			product.setReference(reference);
			product.setProductName(productName);
			product.setAmount(amount);
			productRepository.save(product);
			
		}else {
			productRepository.save(product);
		}
	}
}
