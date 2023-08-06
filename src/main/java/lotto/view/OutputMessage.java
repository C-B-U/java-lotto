package lotto.view;

public enum OutputMessage {

    GUIDE_PURCHASE("구입 금액을 입력해주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_MESSAGE("당첨 통계"),
    LINE("---"),
    BUY_NUMBER("%d개를 구매했습니다.\n"),
    PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}