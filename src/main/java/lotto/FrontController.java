package lotto;

public class FrontController {
    private final LottoController lottoController;

    public FrontController(final LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public void playLotto() {
        lottoController.saveLotto();
        final Integer publishNum = lottoController.getPublishNum();
        lottoController.publishLottoTickets(publishNum);
        final WinningNumber winningNumber = lottoController.getWinningNumber();
    }
}
