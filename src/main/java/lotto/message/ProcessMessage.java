package lotto.message;

public enum ProcessMessage {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    STATISTICS_MESSAGE("당첨 통계\n---");


    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
