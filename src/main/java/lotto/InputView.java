package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.ProcessMessage.*;

public class InputView {
    private static final int LOTTO_PRICE = 1000;
    InputValidator inputValidator = new InputValidator();

    public int inputPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE.getMessage());
        String purchaseAmount = Console.readLine();
        inputValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount)/LOTTO_PRICE;
    }

    public void inputWinningNumbers() {
        System.out.println(INPUT_WINNING_MESSAGE.getMessage());
    }

    public void inputBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE.getMessage());
    }
}
