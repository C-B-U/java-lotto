package lotto;

import java.text.NumberFormat;
import java.util.List;

public class OutputManager {
    private final NumberFormat numberFormat;

    public OutputManager() {
        this.numberFormat = NumberFormat.getNumberInstance();
    }

    public void printStartMessage() {
        System.out.println(LottoMessage.BUY_TO_START);
    }

    public void printPublishNum(final Integer publishNum) {
        System.out.println(String.format(LottoMessage.PUBLISH_NUM.toString(), publishNum));
    }

    public void printLottoList(final List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public void printCreateWinningNumber() {
        System.out.println(LottoMessage.CREATE_WINNING_NUMBER);
    }

    public void printCreateBonusNumber() {
        System.out.println(LottoMessage.CREATE_BONUS_NUMBER);
    }

    public void printWinningStatistics() {
        System.out.println(LottoMessage.WINNING_STATISTICS);
    }

    public void printResult(final ResultMap resultMap) {
        resultMap.getResultMap().forEach(((result, numOfResult) ->{
                    if (!result.equals(RewardMoney.NONE)) {
                        printResultByMoney(result, numOfResult);
                    }
        }));
    }

    private void printResultByMoney(final RewardMoney rewardMoney, final Integer numOfResult) {
        RewardMoneyMap rewardMoneyMap = RewardMoneyMap.getInstance();

        if (rewardMoney.equals(RewardMoney.MATCH_WITH_BONUS)) {
            System.out.println(String.format(
                    LottoMessage.BONUS_MATCH.toString(),
                    rewardMoneyMap.getMatchNum(rewardMoney), numberFormat.format(rewardMoney.toValue()), numOfResult));
            return;
        }
        System.out.println(String.format(
                LottoMessage.NUM_OF_MATCH.toString(),
                rewardMoneyMap.getMatchNum(rewardMoney), numberFormat.format(rewardMoney.toValue()), numOfResult));
    }

    public void printEarningRate(final Double earningRate) {
        System.out.println(String.format(LottoMessage.EARNING_RATE.toString(), earningRate));
    }
}
