package lotto;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";
    private static final String LIST_WITH_COMMA_MATCHER = "\\d+,\\d+,\\d+,\\d+,\\d+,\\d+";

    public void validateIsNumeric(final String buyAmountInput) {
        if (!buyAmountInput.matches(NUMERIC_MATCHER)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ERROR.toString());
        }
    }

    public void validateMultiplyOfThousand(final Integer buyAmountInput) {
        if (buyAmountInput % Number.THOUSAND.toValue() != Number.ZERO.toValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLY_OF_THOUSAND_ERROR.toString());
        }
    }

    public void validateIsListWithComma(final String input) {
        if (!Pattern.matches(LIST_WITH_COMMA_MATCHER, input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LIST_WITH_COMMA_ERROR.toString());
        }
    }
}
