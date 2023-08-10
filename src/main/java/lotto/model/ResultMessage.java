package lotto.model;

public enum ResultMessage {

    MATCH_NUMBER_MESSAGE("%d개 일치"),
    BONUS_MESSAGE(", 보너스 볼 일치"),
    AMOUNT_MESSAGE(" (%,d원) - "),
    WINNING_NUMBER_MESSAGE("%d개"),
    NEW_LINE("\n");
    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
