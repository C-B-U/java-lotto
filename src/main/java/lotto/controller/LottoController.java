package lotto.controller;

import lotto.model.*;
import lotto.view.InputFactory;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputFactory inputFactory;

    public LottoController(OutputView outputView, InputFactory inputFactory) {
        this.outputView = outputView;
        this.inputFactory = inputFactory;
    }

    public void start() {
        try {
            PlayerLottoes playerLottoes = buyLotto();
            WinningLotto winningLotto = createWinningLotto();
            calculateResult(playerLottoes, winningLotto);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error.getMessage());
        }
    }

    private PlayerLottoes buyLotto() {
        LottoCounter lottoCounter = new LottoCounter(inputFactory.readPurchaseAmount());
        PlayerLottoes playerLottoes = new PlayerLottoes(lottoCounter.getLotteryTicket());
        outputView.printPurchaseCount(lottoCounter.getLotteryTicket());
        outputView.printPlayerLottoes(playerLottoes);
        return playerLottoes;
    }

    private WinningLotto createWinningLotto() {
        return new WinningLotto(inputFactory.readWinningNumber(), inputFactory.readBonusNumber());
    }

    private void calculateResult(PlayerLottoes playerLottoes, WinningLotto winningLotto) {
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto, playerLottoes);
        outputView.printLottoResult(lottoResultCalculator.getRankingsResult());
        outputView.printProfit(lottoResultCalculator.calculateYield());
    }
}
