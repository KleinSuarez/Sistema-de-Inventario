package co.software.apiinventory.domain;

import co.software.apiinventory.domain.exception.ExceptionInvalidValue;
import co.software.apiinventory.domain.exception.ExceptionRequiredValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentsValidator {
    public static void validateMandatory(Object value, String message) {
        if (value == null) {
            throw new ExceptionRequiredValue(message);
        }

    }

    public static void validateRegex(String email, String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new ExceptionInvalidValue(message);
        }
    }


    public static void validateNumeric(String valor, String message) {
        try {
            Long.parseLong(valor);
        } catch (NumberFormatException numberFormatException) {
            throw new ExceptionInvalidValue(message);
        }
    }
}
