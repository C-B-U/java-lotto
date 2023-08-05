package lotto.controller;

import lotto.Lotto;
import lotto.Model.LottoCounter;
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
        int purchaseAmount = inputFactory.readPurchaseAmount();
        LottoCounter lottoCounter = new LottoCounter(purchaseAmount);
        Lotto lotto = inputFactory.readWinningNumber();
    }
}
