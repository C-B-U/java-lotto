package lotto.view;

import java.util.regex.Pattern;

public class InputValidator {

    String DELIMITER_REGEXP = "(\\d|,)+(\\d)";

    public void validateBonusNumber(String bonusNumber) {
        isInteger(bonusNumber);
    }

    public void validatePurchaseAmount(String amount) {
        isInteger(amount);
    }

    public void validateWinningNumbers(String winningNumbers) {
        isContainComma(winningNumbers);
    }

    private void isInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private void isContainComma(String userInput) {
        if (!Pattern.matches(DELIMITER_REGEXP, userInput)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_CONTAIN_COMMA;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
