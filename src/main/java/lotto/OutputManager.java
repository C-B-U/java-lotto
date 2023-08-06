package lotto;

public class OutputManager {

    public void printStartMessage() {
        System.out.println(LottoMessage.START_MESSAGE);
    }

    public void printPublishNum(final Integer publishNum) {
        System.out.println(String.format(LottoMessage.PUBLISH_NUM_MESSAGE.toString(), publishNum));
    }
}
