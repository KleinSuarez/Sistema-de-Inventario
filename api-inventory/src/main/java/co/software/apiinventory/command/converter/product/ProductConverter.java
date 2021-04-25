package co.software.apiinventory.command.converter.product;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.domain.ArgumentsValidator;
import co.software.apiinventory.domain.ExistenceValidator;
import co.software.apiinventory.domain.message.Message;
import co.software.apiinventory.model.Product;
import co.software.apiinventory.model.ProductType;
import co.software.apiinventory.repository.product.ProductRepository;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private static final String MANDATORY_PRODUCT_NAME = "The product name is mandatory";
    private static final String MANDATORY_PRODUCT_REFERENCE = "The product reference is mandatory";
    private static final String MANDATORY_PRODUCT_STOCK = "The initial stock is mandatory";
    private static final String REFERENCE_PRODUCT_EXISTS = "The product reference already exist";

    @Autowired
    private ProductConsultationService productConsultationService;

    public Product insert(ProductDTO productDTO){
        Product product = new Product();

        ExistenceValidator.existsReferenceProduct(productDTO.getReference(), productConsultationService.listAllProducts(), REFERENCE_PRODUCT_EXISTS);

        this.ArgumentsValidations(productDTO);

        product.setProductName(productDTO.getProductName());
        product.setReference(productDTO.getReference());
        product.setStock(productDTO.getStock());
        product.setProductType(new ProductType(productDTO.getIdProductType(), productDTO.getProductTypeName()));
        return product;
    }

    public Product update(ProductDTO productDTO) {
        ExistenceValidator.existenceIdProduct(productConsultationService.findById(productDTO.getIdProduct()), Message.PRODUCT_DONT_EXIST);
        Product productUpdate = productConsultationService.findById(productDTO.getIdProduct());

        productUpdate.setProductName(productDTO.getProductName());
        productUpdate.setReference(productDTO.getReference());
        productUpdate.setStock(productDTO.getStock());
        productUpdate.setProductType(new ProductType(productDTO.getIdProductType(), productDTO.getProductTypeName()));
        return productUpdate;
    }

    public void ArgumentsValidations (ProductDTO productDTO){
        ArgumentsValidator.validateMandatory(productDTO.getProductName(), MANDATORY_PRODUCT_NAME);
        ArgumentsValidator.validateMandatory(productDTO.getReference(), MANDATORY_PRODUCT_REFERENCE);
        ArgumentsValidator.validateMandatory(productDTO.getStock(), MANDATORY_PRODUCT_STOCK);
    }
}
