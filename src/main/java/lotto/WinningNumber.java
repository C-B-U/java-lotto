package lotto;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public WinningNumber(final List<Integer> winningNumbers, final Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
