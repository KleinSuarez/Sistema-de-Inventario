package co.software.apiinventory.command.converter.product;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.domain.ArgumentsValidator;
import co.software.apiinventory.model.Product;
import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.service.productType.consultation.ConsultationProductTypeService;
import co.software.apiinventory.service.productType.consultation.impl.ConsultationProductTypeServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private static final String MANDATORY_PRODUCT_NAME = "The product name is mandatory";

    public Product insert(ProductDTO productDTO){
        Product product = new Product();
        ArgumentsValidator.validateMandatory(productDTO.getProductName(), MANDATORY_PRODUCT_NAME);
        product.setProductName(productDTO.getProductName());
        product.setReference(productDTO.getReference());
        product.setStock(productDTO.getStock());
        product.setProductType(new ProductType(productDTO.getIdProductType(), productDTO.getProductTypeName()));
        return product;
    }
}
