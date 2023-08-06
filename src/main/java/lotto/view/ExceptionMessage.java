package lotto.view;

public enum ExceptionMessage {

    NOT_INTEGER("[ERROR] 번호는 숫자만 입력할 수 있습니다."),
    INCORRECT_RANGE("[ERROR] 올바르지 않은 범위의 숫자입니다."),
    INCORRECT_AMOUNT("[ERROR] 금액은 천 원단위로 입력할 수 있습니다."),
    INCORRECT_LOTTO_SIZE("[ERROR] 6개의 숫자만 입력할 수 있습니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    DUPLICATE_WINNING_NUMBER_AND_BONUS("[ERROR] 당첨 숫자와 보너스 숫자가 중복됩니다."),
    NOT_CONTAIN_COMMA("[ERROR] ','로 숫자를 구분하여 주십시오.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
