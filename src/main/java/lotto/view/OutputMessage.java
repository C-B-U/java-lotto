package lotto.view;

public enum OutputMessage {

    GUIDE_PURCHASE("구입 금액을 입력해주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
