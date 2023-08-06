package lotto;

public class FrontController {
    private final LottoController lottoController;

    public FrontController(final LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void playLotto() {
        lottoController.getPublishNum();
        lottoController.publishLotto();
        lottoController.getWinningNumber();
        lottoController.checkWinningNumber();
        lottoController.checkEarningRate();
    }
}
