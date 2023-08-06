package lotto;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    NON_NUMERIC_ERROR("숫자값만 입력 가능합니다."),
    NOT_MULTIPLY_ERROR("%d의 배수만 입력 가능합니다."),
    NOT_LIST_WITH_COMMA_ERROR("콤마로 구분된 %d개의 숫자 형태로만 입력 가능합니다."),
    NOT_VALID_ELEMENTS_NUM("리스트의 원소 개수는 %d개여야 합니다."),
    NOT_UNIQUE_ELEMENTS("리스트에 중복 원소가 존재합니다."),
    CANNOT_FIND_RESULT("결과를 찾을 수 없습니다."),
    NOT_VALID_LOTTO_NUMBER_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX.message + this.message;
    }
}
