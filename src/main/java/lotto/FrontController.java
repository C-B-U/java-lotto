package lotto;

public class FrontController {
    private final LottoController lottoController;
    private final OutputManager outputManager;

    public FrontController(final LottoController lottoController, final OutputManager outputManager) {
        this.lottoController = lottoController;
        this.outputManager = outputManager;
    }

    public void playLotto() {
        try {
            lottoController.getPublishNum();
            lottoController.publishLotto();
            lottoController.getWinningNumber();
            lottoController.checkWinningNumber();
            lottoController.checkEarningRate();
        } catch (final IllegalArgumentException e) {
            outputManager.printErrorMessage(e.getMessage());
        }
    }
}
