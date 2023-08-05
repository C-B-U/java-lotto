package lotto.Model;

public class LottoCounter {

    private final int lotteryTicket;
    private static final Integer LOTTO_PRICE = 1000;

    public LottoCounter(int payment) {
        this.lotteryTicket = calculateLotteryTicket(payment);
    }

    public int calculateLotteryTicket(int payment) {
        return payment / LOTTO_PRICE;
    }

    public int getLotteryTicket() {
        return lotteryTicket;
    }
}
