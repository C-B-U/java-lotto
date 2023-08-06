package lotto;

public class LottoController {
    private final LottoService lottoService;
    private final OutputManager outputManager;
    private final InputManager inputManager;

    public LottoController(final LottoService lottoService, final OutputManager outputManager, final InputManager inputManager) {
        this.lottoService = lottoService;
        this.outputManager = outputManager;
        this.inputManager = inputManager;
    }

    public void startLotto() {
        lottoService.saveLotto();
        outputManager.printStartMessage();
        final Integer buyAmount = inputManager.buyAmountInput();
        final Integer publishNum = lottoService.getPublishNum(buyAmount);
        outputManager.printPublishNum(publishNum);
    }
}
