package co.software.apiinventory.domain;

import co.software.apiinventory.domain.exception.ExceptionRequiredValue;

public class ArgumentsValidator {
    public static void validateMandatory(Object value, String message) {
        if (value == null) {
            throw new ExceptionRequiredValue(message);
        }
    }
}
