package lotto.dto;

import lotto.repositroy.BonusLotto;
import lotto.repositroy.Lotto;

public class AllLottoes {
    private final Lotto lotto;
    private final BonusLotto bonusLotto;

    public AllLottoes(Lotto lotto, BonusLotto bonusLotto) {
        this.lotto = lotto;
        this.bonusLotto = bonusLotto;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusLotto getBonusLotto() {
        return bonusLotto;
    }
}
