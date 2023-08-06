package lotto.member.exception;

public enum InputErrorMessage {
    INPUT_THOUSAND("로또 구입 금액은 1,000 단위 입니다."),
    INPUT_NUMBER("로또 구입 금액은 오로지 숫자입니다."),
    INPUT_NOT_DUPLICATE_AND_SIX("로또 번호는 중복되지 않는 6자리 수 입니다."),
    INPUT_NUMBER_RANGE("보너스 번호는 1~45 사이의 당첨 번호에 포함되지 않는 숫자입니다.");

    private final String message;
    private final String error = "[ERROR] ";

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return error + message;
    }
}
