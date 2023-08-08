package lotto.model;

import lotto.view.ExceptionMessage;

public class LottoCounter {

    private final int lotteryTicket;

    public LottoCounter(int payment) {
        validateThousandUnits(payment);
        this.lotteryTicket = calculateLotteryTicket(payment);
    }

    public int calculateLotteryTicket(int payment) {
        return payment / Constant.LOTTO_PRICE.getConstant();
    }

    public int getLotteryTicket() {
        return lotteryTicket;
    }

    private void validateThousandUnits(Integer amount) {
        if((amount % Constant.LOTTO_PRICE.getConstant()) != 0) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_AMOUNT;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
