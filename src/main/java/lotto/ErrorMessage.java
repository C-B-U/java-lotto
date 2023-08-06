package lotto;

public enum ErrorMessage {
    NON_NUMERIC_ERROR("[ERROR] 숫자값만 입력 가능합니다."),
    NOT_MULTIPLY_OF_THOUSAND_ERROR("[ERROR] 1000의 배수만 입력 가능합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }
}
