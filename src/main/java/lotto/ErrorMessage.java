package lotto;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    NON_NUMERIC_ERROR("숫자값만 입력 가능합니다."),
    NOT_MULTIPLY_OF_THOUSAND_ERROR("1000의 배수만 입력 가능합니다."),
    NOT_LIST_WITH_COMMA_ERROR("콤마로 구분된 6개의 숫자 형태로만 입력 가능합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX.message + message;
    }
}
