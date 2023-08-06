package lotto;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";

    public void validateIsNumeric(final String buyAmountInput) {
        if (!buyAmountInput.matches(NUMERIC_MATCHER)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ERROR.toString());
        }
    }

    public void validateMultiplyOfThousand(final Integer buyAmountInput) {
        if (buyAmountInput % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MULTIPLY_OF_THOUSAND_ERROR.toString());
        }
    }
}
