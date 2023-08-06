package lotto.controller;

import lotto.Model.*;
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
        outputView.guidePurchaseLotto();
        LottoCounter lottoCounter = new LottoCounter(inputFactory.readPurchaseAmount());
        WinningLotto winningLotto = new WinningLotto(inputFactory.readWinningNumber(), inputFactory.readBonusNumber());
        PlayerLottoes playerLottoes = new PlayerLottoes(lottoCounter.getLotteryTicket());
        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();
        System.out.println(lottoResult.calculateYield());
    }
}
