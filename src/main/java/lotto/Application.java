package lotto;

import lotto.lottoManager.controller.LottoManagerController;

public class Application {
    public static void main(String[] args) {
        LottoManagerController lottoManagerController = new LottoManagerController();
        lottoManagerController.startLotto();
    }
}
