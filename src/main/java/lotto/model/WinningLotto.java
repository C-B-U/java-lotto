package lotto.model;

import lotto.view.ExceptionMessage;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validateLottoAndBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateLottoAndBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.hasNumber(bonusNumber.getBonus())) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_WINNING_NUMBER_AND_BONUS;
            throw new IllegalArgumentException(message.toString());
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
