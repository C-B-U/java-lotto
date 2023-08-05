package lotto;

import lotto.controller.LottoController;
import lotto.view.InputFactory;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new OutputView(), new InputFactory());
        lottoController.start();
    }
}
