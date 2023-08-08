package lotto.Model;

public class LottoResultCalculator {

    private final WinningLotto winningLotto;
    private final PlayerLottoes playerLottoes;
    private final LottoResult lottoResult;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static final int THIRD_RANKING_NUMBER = 5;

    public LottoResultCalculator(WinningLotto winningLotto, PlayerLottoes playerLottoes) {
        this.winningLotto = winningLotto;
        this.playerLottoes = playerLottoes;
        this.lottoResult = new LottoResult();
    }

    public void calculateWinningRank() {
        for (Lotto lotto : playerLottoes.getLottoes()) {
            int matchNumber = calculateMatchNumber(lotto);
            boolean matchBonusNumber = hasBonusNumber(matchNumber, lotto);
            Ranking ranking = Ranking.calculate(calculateMatchNumber(lotto), matchBonusNumber);
            lottoResult.putResult(ranking);
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

    public LottoResult getRankingsResult() {
        return lottoResult;
    }

    public double calculateYield() {
        double totalPrize = calculateTotalPrize();
        int lotteryTickets = playerLottoes.size();
        return (totalPrize / (LOTTO_PRICE * lotteryTickets)) * PERCENTAGE;
    }

    private double calculateTotalPrize() {
        double sum = 0;
        for(Ranking ranking: lottoResult.keyset()) {
            sum += ranking.getPrize() * lottoResult.get(ranking);
        }
        return sum;
    }
}
