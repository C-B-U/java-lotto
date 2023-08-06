package lotto.view;

public class InputValidator {
    
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int Thousand = 1000;

    public void validateBonusNumber(String bonusNumber) {
        isInteger(bonusNumber);
        isCorrectRange(bonusNumber);
    }

    public void validatePurchaseAmount(String amount) {
        isInteger(amount);
        isThousandUnits(amount);
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

    private void isCorrectRange(String bonusNumber) {
        int bonus = Integer.parseInt(bonusNumber);
        if (bonus < MIN_NUMBER || bonus > MAX_NUMBER) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private void isThousandUnits(String userInput) {
        int amount = Integer.parseInt(userInput);
        if((amount % Thousand) != 0) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_AMOUNT;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private void isContainComma(String userInput) {
        if (!userInput.contains(",")) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_CONTAIN_COMMA;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
