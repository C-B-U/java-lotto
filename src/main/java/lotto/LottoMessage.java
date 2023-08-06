package lotto;

public enum LottoMessage {
    START_MESSAGE("구입금액을 입력해 주세요."),
    PUBLISH_NUM_MESSAGE("%d개를 구매했습니다.");
    private final String message;

    LottoMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
