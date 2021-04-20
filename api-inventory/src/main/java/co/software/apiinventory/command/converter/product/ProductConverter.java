package co.software.apiinventory.command.converter.product;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.domain.ArgumentsValidator;
import co.software.apiinventory.model.Product;
import co.software.apiinventory.model.ProductType;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private static final String MANDATORY_PRODUCT_NAME = "The product name is mandatory";
    private static final String MANDATORY_PRODUCT_REFERENCE = "The product reference is mandatory";
    private static final String MANDATORY_PRODUCT_STOCK = "The initial stock is mandatory";


    public Product insert(ProductDTO productDTO){
        Product product = new Product();
        ArgumentsValidator.validateMandatory(productDTO.getProductName(), MANDATORY_PRODUCT_NAME);
        ArgumentsValidator.validateMandatory(productDTO.getReference(), MANDATORY_PRODUCT_REFERENCE);
        ArgumentsValidator.validateMandatory(productDTO.getStock(), MANDATORY_PRODUCT_STOCK);
        product.setProductName(productDTO.getProductName());
        product.setReference(productDTO.getReference());
        product.setStock(productDTO.getStock());
        product.setProductType(new ProductType(productDTO.getIdProductType(), productDTO.getProductTypeName()));
        return product;
    }
}
