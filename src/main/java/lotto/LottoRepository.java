package lotto;

import java.util.List;

public class LottoRepository {
    private Lotto lotto;
    private List<LottoTicket> lottoTicket;
    private WinningNumber winningNumber;

    public void saveLotto(final Lotto lotto) {
        this.lotto = lotto;
    }

    public void saveLottoTicket(final List<LottoTicket> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public void saveWinningNumber(final WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }
}
