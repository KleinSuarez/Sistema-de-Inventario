package co.software.apiinventory.domain;

import co.software.apiinventory.domain.exception.ExceptionNotExistProduct;
import co.software.apiinventory.domain.exception.ExeptionAlreadyExitsReference;
import co.software.apiinventory.model.Product;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExistenceValidator {

    @Autowired
    private ProductConsultationService productConsultationService;

    public static void existsReferenceProduct (String reference , List<Product> products, String message) {
        for (Product product : products ) {
            if (product.getReference().equals(reference)){
                throw new ExeptionAlreadyExitsReference(message);
            }
        }
    }
    public static void existenceIdProduct(Product product, String message){
        if(product == null){
            throw new ExceptionNotExistProduct(message);
        }
    }
}
