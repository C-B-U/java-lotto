package lotto.member.exception;

public enum LottoRule {

    PRICE_UNIT(1000),
    SIZE(6),
    START_NUMBER(1),
    END_NUMBER(45);

    private final int value;

    LottoRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
