package lotto.Model;

import java.util.HashMap;
import java.util.Map;

public class LottoResultCalculator {

    private final WinningLotto winningLotto;
    private final PlayerLottoes playerLottoes;
    private final Map<Ranking, Integer> rankings;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static final int THIRD_RANKING_NUMBER = 5;

    public LottoResultCalculator(WinningLotto winningLotto, PlayerLottoes playerLottoes) {
        this.winningLotto = winningLotto;
        this.playerLottoes = playerLottoes;
        this.rankings = new HashMap<>();
    }

    public void calculateWinningRank() {
        for (Lotto lotto : playerLottoes.getLottoes()) {
            int matchNumber = calculateMatchNumber(lotto);
            boolean matchBonusNumber = hasBonusNumber(matchNumber, lotto);
            Ranking ranking = Ranking.calculate(calculateMatchNumber(lotto), matchBonusNumber);
            rankings.put(ranking, getPlus(ranking));
        }
    }

    private Integer calculateMatchNumber(Lotto lotto) {
        Lotto winningLottoNumbers = winningLotto.getLotto();
        return (int) winningLottoNumbers.getNumbers()
                .stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private boolean hasBonusNumber(int matchNumber, Lotto lotto) {
        if (matchNumber != THIRD_RANKING_NUMBER) {
            return false;
        }
        BonusNumber bonusNumber = winningLotto.getBonusNumber();
        return lotto.hasNumber(bonusNumber.getBonus());
    }

    private Integer getPlus(Ranking ranking) {
        return rankings.getOrDefault(ranking, 0) + 1;
    }


    public Map<Ranking, Integer> getRankingsResult() {
        return rankings;
    }

    public double calculateYield() {
        double totalPrize = calculateTotalPrize();
        int lotteryTickets = playerLottoes.size();
        return (totalPrize / (LOTTO_PRICE * lotteryTickets)) * PERCENTAGE;
    }

    private double calculateTotalPrize() {
        double sum = 0;
        for(Ranking ranking: rankings.keySet()) {
            sum += ranking.getPrize() * rankings.get(ranking);
        }
        return sum;
    }
}
