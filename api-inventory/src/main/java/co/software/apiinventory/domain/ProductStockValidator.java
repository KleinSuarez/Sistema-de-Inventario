package co.software.apiinventory.domain;

import co.software.apiinventory.domain.exception.ExceptionInsufficientStock;
import co.software.apiinventory.domain.exception.ExceptionRequiredValue;

public class ProductStockValidator {
    public static void productStockValidator(Integer value, String message) {
        if (value < 0) {
            throw new ExceptionInsufficientStock(message);
        }
    }
}
