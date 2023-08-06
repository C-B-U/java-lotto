package lotto;

public class ProfitCalculator {
    private static final int PERCENTAGE = 100;
    private final String profitRate;

    public ProfitCalculator(int money, long totalCashPrize) {
        this.profitRate = calculateProfitRate(money, totalCashPrize);
    }

    private String calculateProfitRate(int money, long totalCashPrize) {
        double profitRate = ((double) totalCashPrize / money) * PERCENTAGE;
        return String.format("%.1f", profitRate);
    }

    public String getProfitRate() {
        return this.profitRate;
    }
}
