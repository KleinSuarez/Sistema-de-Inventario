package co.software.apiinventory.domain.message;

public class Message {
    public static final String PRODUCT_DONT_EXIST = "The product selected dont exists";

    public static final String PRODUCT_INSUFFICIENT_STOCK = "the product stock is not enough to carry out the transaction";

    public static final String MANDATORY_PRODUCT_NAME = "The product name is mandatory";
    public static final String MANDATORY_PRODUCT_REFERENCE = "The product reference is mandatory";
    public static final String MANDATORY_PRODUCT_STOCK = "The initial stock is mandatory";
    public static final String REFERENCE_PRODUCT_EXISTS = "The product reference already exist";
}
