package lotto.member.controller;

public enum InputMessage {

    PURCHASE("구입 금액을 입력해 주세요"),
    WIN_NUMBER("당첨 번호를 입력해 주세요"),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BLANK("\n");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
