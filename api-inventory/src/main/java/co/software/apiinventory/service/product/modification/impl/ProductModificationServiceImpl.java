package co.software.apiinventory.service.product.modification.impl;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.modification.ProductModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductModificationServiceImpl implements ProductModificationService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Integer update(Integer idProduct, Product product) {
        productRepository.save(product);
        return product.getIdProduct();
    }
}
