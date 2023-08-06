package lotto;

import java.util.List;

public class OutputManager {

    public void printStartMessage() {
        System.out.println(LottoMessage.START_MESSAGE);
    }

    public void printPublishNum(final Integer publishNum) {
        System.out.println(String.format(LottoMessage.PUBLISH_NUM_MESSAGE.toString(), publishNum));
    }

    public void printLottoList(final List<Lotto> lottoList) {
        lottoList.forEach(System.out::println);
    }

    public void printCreateWinningNumber() {
        System.out.println(LottoMessage.CREATE_WINNING_NUMBER_MESSAGE);
    }

    public void printCreateBonusNumber() {
        System.out.println(LottoMessage.CREATE_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics() {
        System.out.println(LottoMessage.WINNING_STATISTICS);
    }
}
