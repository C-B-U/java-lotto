package lotto.Model;

import lotto.view.ExceptionMessage;

public class LottoCounter {

    private final int lotteryTicket;
    private static final Integer LOTTO_PRICE = 1000;

    public LottoCounter(int payment) {
        validateThousandUnits(payment);
        this.lotteryTicket = calculateLotteryTicket(payment);
    }

    public int calculateLotteryTicket(int payment) {
        return payment / LOTTO_PRICE;
    }

    public int getLotteryTicket() {
        return lotteryTicket;
    }

    private void validateThousandUnits(Integer amount) {
        if((amount % LOTTO_PRICE) != 0) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_AMOUNT;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
