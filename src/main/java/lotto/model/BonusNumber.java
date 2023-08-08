package lotto.model;

import lotto.view.ExceptionMessage;

public class BonusNumber {

    private final int bonusNumber;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public BonusNumber(int bonusNumber) {
        validateCorrectRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonus() {
        return bonusNumber;
    }

    private void validateCorrectRange(int bonusNumber) {
        if (!(MIN_NUMBER <= bonusNumber && bonusNumber <= MAX_NUMBER)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
