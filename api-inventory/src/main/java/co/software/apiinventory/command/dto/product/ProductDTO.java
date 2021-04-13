package co.software.apiinventory.command.dto.product;

import co.software.apiinventory.model.ProductType;
import lombok.Data;

@Data
public class ProductDTO {
    private Integer idProduct;
    private Integer idProductType;
    private String reference;
    private String productName;
    private String productTypeName;
    private int stock;
}
