package lotto;

public enum ErrorMessage {
    BONUS_DUPLICATED_WITH_WINNING("[ERROR] 보너스 번호가 당첨 번호에 포함되어 있습니다."),
    PURCHASE_AMOUNT_IS_THOUSAND_UNIT("[ERROR] 구매 금액은 1000원 단위여야 합니다."),
    WINNING_IS_ONLY_NUMERIC("[ERROR] 당첨 번호는 숫자만 입력 가능합니다."),
    BONUS_IS_ONLY_NUMERIC("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_IS_ONLY_NUMERIC("[ERROR] 구매 금액은 숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_HAS_NOT_BLANK("[ERROR] 구매 금액은 공백이 없어야 합니다."),
    LOTTO_HAS_DUPLICATED("[ERROR] 로또 번호에 중복되는 숫자가 존재합니다."),
    LOTTO_HAS_SIX_NUMBER("[ERROR] 로또 번호는 6개로 구성되어야 합니다."),
    LOTTO_IS_1_MORE_OR_45_LESS("[ERROR] 로또 번호는 1이상 45이하여야 합니다."),
    BONUS_IS_1_MORE_OR_45_LESS("[ERROR] 보너스 번호는 1이상 45이하여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
