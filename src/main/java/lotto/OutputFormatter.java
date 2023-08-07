package lotto;

import java.text.NumberFormat;

public class OutputFormatter {
    private final NumberFormat numberFormat;

    public OutputFormatter() {
        this.numberFormat = NumberFormat.getInstance();
    }

    public String formatResultString(final RewardMoney rewardMoney, final Integer numOfResult) {
        RewardMoneyMap rewardMoneyMap = RewardMoneyMap.getInstance();

        if (rewardMoney.equals(RewardMoney.MATCH_WITH_BONUS)) {
            return String.format(
                    LottoMessage.BONUS_MATCH.toString(),
                    rewardMoneyMap.getMatchNum(rewardMoney), numberFormat.format(rewardMoney.toValue()), numOfResult);
        }
        return String.format(
                LottoMessage.NUM_OF_MATCH.toString(),
                rewardMoneyMap.getMatchNum(rewardMoney), numberFormat.format(rewardMoney.toValue()), numOfResult);
    }

    public String formatEarningRateString(final Double earningRate) {
        return String.format(LottoMessage.EARNING_RATE.toString(), earningRate);
    }

    public String formatPublishNum(final Integer publishNum) {
        return String.format(LottoMessage.PUBLISH_NUM.toString(), publishNum);
    }
}
