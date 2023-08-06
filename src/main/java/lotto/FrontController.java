package lotto;

public class FrontController {
    private final LottoController lottoController;

    public FrontController(final LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void playLotto() {
        final Integer publishNum = lottoController.getPublishNum();
        lottoController.publishLotto(publishNum);
        lottoController.getWinningNumber();
        lottoController.checkWinningNumber();
    }
}
