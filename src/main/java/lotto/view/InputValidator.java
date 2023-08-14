package lotto.view;

import java.util.regex.Pattern;

public class InputValidator {

    String DELIMITER_REGEXP = "(\\d|,)+(\\d)";
    String NUMBER_REGEXP = "^\\d*$";

    public void validateBonusNumber(String bonusNumber) {
        validateInteger(bonusNumber);
    }

    public void validatePurchaseAmount(String amount) {
        validateInteger(amount);
    }

    public void validateWinningNumbers(String winningNumbers) {
        validateContainComma(winningNumbers);
    }

    private void validateInteger(String userInput) {
        if (!Pattern.matches(NUMBER_REGEXP, userInput)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private void validateContainComma(String userInput) {
        if (!Pattern.matches(DELIMITER_REGEXP, userInput)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_CONTAIN_COMMA;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
