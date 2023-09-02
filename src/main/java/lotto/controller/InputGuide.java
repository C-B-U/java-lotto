package lotto.controller;

public enum InputGuide {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO_ANSWER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_ANSWER("보너스 번호를 입력해 주세요.");

    private final String content;

    InputGuide(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
