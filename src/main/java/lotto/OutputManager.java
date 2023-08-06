package lotto;

import java.util.List;

public class OutputManager {

    public void printStartMessage() {
        System.out.println(LottoMessage.START_MESSAGE);
    }

    public void printPublishNum(final Integer publishNum) {
        System.out.println(String.format(LottoMessage.PUBLISH_NUM_MESSAGE.toString(), publishNum));
    }

    public void printLottoTickets(final List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(System.out::println);
    }

    public void printCreateWinningNumber() {
        System.out.println(LottoMessage.CREATE_WINNING_NUMBER_MESSAGE);
    }
}
