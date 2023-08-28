package lotto.repositroy;

import lotto.ErrorMessage;
import lotto.LottoRangeNumber;

import java.util.List;

public class BonusLotto {
    private final Integer number;

    public BonusLotto(Integer number, List<Integer> winNumbers) {
        validate(number, winNumbers);
        this.number = number;
    }

    private void validate(Integer number, List<Integer> winNumbers) {
        checkInRage(number);
        checkNotDuplicated(number, winNumbers);
    }

    private void checkInRage(Integer number) {
        if (number > LottoRangeNumber.MAX_LOTTO_NUM.getNum() || number < LottoRangeNumber.MIN_LOTTO_NUM.getNum()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private void checkNotDuplicated(Integer number, List<Integer> winNumbers) {
        if (winNumbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.getMessage());
        }
    }
}
