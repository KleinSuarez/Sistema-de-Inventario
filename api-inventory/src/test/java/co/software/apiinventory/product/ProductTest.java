package co.software.apiinventory.product;

import co.software.apiinventory.command.dto.product.ProductDTO;
import co.software.apiinventory.command.handler.product.insert.ProductInsertHandler;
import co.software.apiinventory.command.handler.product.modification.ProductModificationHandler;
import co.software.apiinventory.domain.message.Message;
import co.software.apiinventory.service.product.consultation.ProductConsultationService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductInsertHandler productInsertHandler;
    @Autowired
    private ProductModificationHandler productModificationHandler;
    @Autowired
    private ProductConsultationService productConsultationService;


    ProductDTO productDTO = new ProductDTO();

    @Autowired
    void setProductTest (){
        productDTO.setIdProduct(1);
        productDTO.setProductName("Portatil");
        productDTO.setReference("REF-009");
        productDTO.setIdProductType(5);
        productDTO.setStock(55);
        productDTO.setActive(true);
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    void emptyNameField () throws Exception {
        expected.expect(RuntimeException.class);
        expected.expectMessage(Message.MANDATORY_PRODUCT_NAME);
        productDTO.setProductName("");

        assertThrows(RuntimeException.class, () -> {
            productInsertHandler.execute(productDTO);
        });
    }

    @Test
    void referenceExist () throws Exception {
        expected.expect(RuntimeException.class);
        expected.expectMessage(Message.MANDATORY_PRODUCT_NAME);
        productDTO.setReference("REF-001");

        assertThrows(RuntimeException.class, () -> {
            productInsertHandler.execute(productDTO);
        });
    }

    @Test
    void emptyReferenceField() throws Exception {
        expected.expect(RuntimeException.class);
        expected.expectMessage(Message.MANDATORY_PRODUCT_REFERENCE);
        productDTO.setReference("");

        assertThrows(RuntimeException.class, () -> {
            productInsertHandler.execute(productDTO);
        });
    }

    @Test
    void validateOutStock() throws Exception {
        expected.expect(RuntimeException.class);
        expected.expectMessage(Message.PRODUCT_INSUFFICIENT_STOCK);
        productDTO.setStock(-2);

        assertThrows(RuntimeException.class, () -> {
            productModificationHandler.execute(productDTO,0,-2);
        });
    }

    @Test
    void validateProductExistence() throws Exception {
        expected.expect(RuntimeException.class);
        expected.expectMessage(Message.PRODUCT_DONT_EXIST);
        productDTO.setIdProduct(7);

        assertThrows(RuntimeException.class, () -> {
            productModificationHandler.execute(productDTO);
        });
    }
}
