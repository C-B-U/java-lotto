package lotto.model;

public class ProfitCalculator {

    private final LottoResult lottoResult;
    private static final int PERCENTAGE = 100;

    public ProfitCalculator(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public double getProfit() {
        double totalPrize = calculateTotalPrize();
        int ticketCount =calculateTicketCount();
        return (totalPrize / (Constant.LOTTO_PRICE.getConstant() * ticketCount)) * PERCENTAGE;
    }

    private double calculateTotalPrize() {
        return lottoResult.keySet()
                .stream()
                .mapToInt((ranking -> ranking.getPrize() * lottoResult.get(ranking)))
                .sum();
    }

    private int calculateTicketCount() {
        return lottoResult.keySet()
                .stream()
                .mapToInt(lottoResult::get)
                .sum();
    }
}
