package lotto.controller;

import lotto.Model.LottoCounter;
import lotto.Model.PlayerLottoes;
import lotto.Model.WinningLotto;
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
        WinningLotto winningLotto = new WinningLotto(inputFactory.readWinningNumber());
        PlayerLottoes playerLottoes = new PlayerLottoes(lottoCounter.getLotteryTicket());
    }
}
