package lotto;

import java.util.List;

public class LottoCustomer {
    private final InputView inputView = new InputView();

    public int buyLotto() {
        return inputView.inputPurchaseAmount();
    }

    public List<Integer> inputWinningNumbers() {
        return inputView.inputWinningNumbers();
    }

    public int inputBonusNumber() {
        return inputView.inputBonusNumber();
    }

}
