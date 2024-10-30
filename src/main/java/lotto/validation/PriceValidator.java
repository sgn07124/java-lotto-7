package lotto.validation;

import enums.Delimiter;
import enums.ErrorMessage;

public class PriceValidator {

    private static final String ERROR_DELIMITER = Delimiter.ERROR.getDelimiter();

    public static void validatePrice(String input) {
        validateNull(input);
        long convertInput = convertToLong(input);
        validateZero(convertInput);
    }

    private static void validateNull(String price) {
        if (isNullOrEmpty(price)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateZero(long price) {
        if (price == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ZERO.getErrorMessage());
        }
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static long convertToLong(String input) {
        return Long.parseLong(input.trim());
    }
}