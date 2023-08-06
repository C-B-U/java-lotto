package lotto;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final OutputManager outputManager;
    private final InputManager inputManager;

    public LottoController(final LottoService lottoService, final OutputManager outputManager, final InputManager inputManager) {
        this.lottoService = lottoService;
        this.outputManager = outputManager;
        this.inputManager = inputManager;
    }

    public Integer getPublishNum() {
        outputManager.printStartMessage();

        final Integer buyAmount = inputManager.buyAmountInput();
        final Integer publishNum = lottoService.getPublishNum(buyAmount);

        outputManager.printPublishNum(publishNum);
        return publishNum;
    }

    public void publishLotto(final Integer publishNum) {
        final List<Lotto> lottoList = lottoService.publishLotto(publishNum);
        outputManager.printLottoList(lottoList);
    }

    public void getWinningNumber() {
        outputManager.printCreateWinningNumber();
        final List<Integer> winningNumberInput = inputManager.winningNumberInput();

        outputManager.printCreateBonusNumber();
        final Integer bonusNumberInput = inputManager.bonusNumberInput();

        lottoService.saveWinningNumber(winningNumberInput, bonusNumberInput);
    }

    public void checkWinningNumber() {
        outputManager.printWinningStatistics();
        final ResultMap resultMap = lottoService.checkWinningNumber();
        outputManager.printResult(resultMap);
    }
}
