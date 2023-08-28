package lotto;

public enum ErrorMessage {
    NOT_SIX_NUMBERS("[ERROR] 당첨 번호는 6개를 입력해 주세요."),
    DUPLICATED_NUMBERS("[ERROR] 당첨 번호의 중복을 제거해 주세요."),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
