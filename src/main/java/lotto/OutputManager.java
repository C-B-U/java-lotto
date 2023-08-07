package lotto;

import java.util.List;

public class OutputManager {
    private final OutputFormatter outputFormatter;

    public OutputManager(final OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public void printStartMessage() {
        System.out.println(LottoMessage.BUY_TO_START);
    }

    public void printPublishNum(final Integer publishNum) {
        System.out.println(outputFormatter.formatPublishNum(publishNum));
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
        resultMap.getResultMap().forEach(((rewardMoney, numOfResult) ->{
                    if (!rewardMoney.equals(RewardMoney.NONE)) {
                        System.out.println(outputFormatter.formatResultString(rewardMoney, numOfResult));
                    }
        }));
    }

    public void printEarningRate(final Double earningRate) {
        System.out.println(outputFormatter.formatEarningRateString(earningRate));
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }
}
