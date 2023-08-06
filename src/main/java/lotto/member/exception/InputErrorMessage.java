package lotto.member.exception;

public enum InputErrorMessage {
    THOUSAND("로또 구입 금액은 1,000 단위 입니다."),
    NUMBER("로또 구입 금액은 오로지 숫자입니다."),
    NOT_DUPLICATE_AND_SIX("로또 번호는 중복되지 않는 6자리 수 입니다."),
    IN_NUMBER_RANGE("보너스 번호는 1~45 사이의 숫자입니다."),
    IN_WIN_LOTTO_NUMBER("당첨 번호에 포함되어 있는 숫자입니다.");

    private final String message;
    private final String error = "[ERROR] ";

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return error + message;
    }
}
