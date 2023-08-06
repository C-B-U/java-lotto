package lotto;

import java.util.List;

public class LottoRepository {
    private List<Lotto> lotto;
    private WinningNumber winningNumber;

    public void saveAllLotto(final List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public void saveWinningNumber(final WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }
}
