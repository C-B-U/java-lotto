package lotto;

import java.util.List;

public class InputValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int IS_THOUSAND_WON_UNIT = 0;


    public static void validatePurchaseAmount(String purchaseAmount) {
        if(Integer.parseInt(purchaseAmount)%LOTTO_PRICE != IS_THOUSAND_WON_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        // 보너스 번호 검사
    }

    public void validateWinningNumber() {
        // 당첨 번호 검사
    }
}
