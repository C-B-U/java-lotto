package lotto.view;

import lotto.Model.Lotto;
import lotto.Model.PlayerLottoes;
import lotto.Model.Ranking;

import java.util.Arrays;
import java.util.Map;

public class OutputView {
    
    private static final int DEFAULT = 0;

    public void printLottoResult(Map<Ranking, Integer> rankingResult) {
        System.out.println(OutputMessage.RESULT_MESSAGE);
        System.out.println(OutputMessage.LINE);
        Arrays.stream(Ranking.values())
                .filter(ranking -> ranking != Ranking.NONE)
                .forEach(ranking -> printRankingMessage(ranking, rankingResult));
    }

    private void printRankingMessage(Ranking ranking, Map<Ranking, Integer> rankingResult) {
        System.out.println(ranking.getMessage(rankingResult.getOrDefault(ranking, DEFAULT)));
    }

    public void printPurchaseCount(int lottoTicketsNumber) {
        System.out.printf(OutputMessage.BUY_NUMBER.toString(), lottoTicketsNumber);
    }

    public void printPlayerLottoes(PlayerLottoes playerLottoes) {
        playerLottoes.getLottoes()
                .forEach(this::printLottoNumber);
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printProfit(Double profit) {
        System.out.printf((OutputMessage.PROFIT_MESSAGE.toString()), profit);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
