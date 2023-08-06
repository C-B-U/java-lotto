package lotto;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";
    private static final String LIST_WITH_COMMA_MATCHER = "\\d+,\\d+,\\d+,\\d+,\\d+,\\d+";
    private static final Integer NONE = 0;
    private static final Integer MONEY_UNIT = 1000;

    public void validateIsNumeric(final String buyAmountInput) {
        if (!buyAmountInput.matches(NUMERIC_MATCHER)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ERROR.toString());
        }
    }

    public void validateMultiplyOfThousand(final Integer buyAmountInput) {
        if (buyAmountInput % MONEY_UNIT != NONE) {
            throw new IllegalArgumentException(String.format(ErrorMessage.NOT_MULTIPLY_ERROR.toString(), MONEY_UNIT));
        }
    }

    public void validateIsListWithComma(final String input) {
        if (!Pattern.matches(LIST_WITH_COMMA_MATCHER, input)) {
            throw new IllegalArgumentException(String.format(ErrorMessage.NOT_LIST_WITH_COMMA_ERROR.toString(), LottoNumberRange.NUMBER_NUM));
        }
    }

    public void validateLottoNumber(final Integer lottoNumberInput) {
        if (lottoNumberInput < LottoNumberRange.MIN_RANGE.toValue() || lottoNumberInput > LottoNumberRange.MAX_RANGE.toValue()) {
            throw new IllegalArgumentException(String.format(ErrorMessage.NOT_VALID_LOTTO_NUMBER_ERROR.toString()));
        }
    }
}
