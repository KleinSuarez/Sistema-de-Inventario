package co.software.apiinventory.service.product.modification.impl;

import co.software.apiinventory.model.Product;
import co.software.apiinventory.model.Transaction;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.repository.transaction.TransactionRepository;
import co.software.apiinventory.service.product.modification.ProductModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ProductModificationServiceImpl implements ProductModificationService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Integer update(Integer idProduct, Product product) {
        productRepository.save(product);
        transactionRepository.save(new Transaction(
                product,
                product.getStock(),
                0,
                new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        return product.getIdProduct();
    }

    @Override
    public Integer updateStock(Integer idProduct, Product product, Integer in, Integer out) {
        productRepository.save(product);
        transactionRepository.save(new Transaction(
                product,
                in,
                out,
                new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
        return product.getIdProduct();
    }
}
