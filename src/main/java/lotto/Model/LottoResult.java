package lotto.Model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final WinningLotto winningLotto;
    private final PlayerLottoes playerLottoes;

    public LottoResult(WinningLotto winningLotto, PlayerLottoes playerLottoes) {
        this.winningLotto = winningLotto;
        this.playerLottoes = playerLottoes;
    }

    public List<Ranking> calculateWinningRank() {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto lotto : playerLottoes.getLottoes()) {
            Ranking ranking = Ranking.calculate(calculateMatchNumber(lotto), hasBonusNumber(lotto));
            rankings.add(ranking);
        }
        return rankings;
    }

    private Integer calculateMatchNumber(Lotto lotto) {
        Lotto winningLottoNumbers = winningLotto.getLotto();
        return (int) winningLottoNumbers.getNumbers()
                .stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        BonusNumber bonusNumber = winningLotto.getBonusNumber();
        return lotto.hasNumber(bonusNumber.getBonus());
    }
}
