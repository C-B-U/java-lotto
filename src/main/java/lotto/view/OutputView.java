package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.PlayerLottoes;

public class OutputView {

    public void printPurchaseMessage() {
        System.out.println(OutputMessage.GUIDE_PURCHASE);
    }

    public void printWinningNumberMessage() {
        System.out.println(OutputMessage.WINNING_NUMBER);
    }

    public void printBonusNumberMessage() {
        System.out.println(OutputMessage.BONUS_NUMBER);
    }

    public void printLottoResult(LottoResult rankingResult) {
        System.out.println(OutputMessage.RESULT_MESSAGE);
        System.out.println(OutputMessage.LINE);
        System.out.println(rankingResult.toString());
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
