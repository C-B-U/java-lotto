package lotto;

public enum LottoMessage {
    BUY_TO_START("구입금액을 입력해 주세요."),
    PUBLISH_NUM("%d개를 구매했습니다."),
    CREATE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    CREATE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    NUM_OF_MATCH("%d개 일치 (%s원) - %d개"),
    BONUS_MATCH("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    EARNING_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
