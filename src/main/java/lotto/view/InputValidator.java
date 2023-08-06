package lotto.view;

public class InputValidator {
    
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public void validateBonusNumber(String bonusNumber) {
        isInteger(bonusNumber);
        isCorrectRange(bonusNumber);
    }

    private void isInteger(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
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
}
