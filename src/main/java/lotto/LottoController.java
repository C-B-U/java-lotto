package lotto;

public class LottoController {
    private final LottoService lottoService;
    private final InputManager inputManager;

    public LottoController(final LottoService lottoService, final InputManager inputManager) {
        this.lottoService = lottoService;
        this.inputManager = inputManager;
    }

    public void startLotto() {
        lottoService.saveLotto();
        final Integer buyAmount = inputManager.buyAmountInput();
    }
}
