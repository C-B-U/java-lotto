package lotto;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";

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
}
