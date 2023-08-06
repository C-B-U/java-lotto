package lotto.producer.service;

public enum OutputMessage {
    ENTER("\n"),
    PURCHASED("개를 구매했습니다."),
    FIRST_BRACKET("["),
    LAST_BRACKET("]"),
    COMMA(","),
    BLANK(" ");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
