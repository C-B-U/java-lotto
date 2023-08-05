package lotto.Model;

import java.util.List;

public class YieldCalculator {

    private final List<Ranking> rankings;
    private final int lotteryTickets;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    public YieldCalculator(List<Ranking> rankings, int lotteryTickets) {
        this.rankings = rankings;
        this.lotteryTickets = lotteryTickets;
    }

    public double calculateYield() {
        double totalPrize = calculateTotalPrize();
        return (totalPrize / (LOTTO_PRICE * lotteryTickets)) * PERCENTAGE;
    }

    private int calculateTotalPrize() {
        return rankings.stream()
                .mapToInt(Ranking::getPrize)
                .sum();
    }
}
