package lotto.Model;

import lotto.Lotto;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }
}
