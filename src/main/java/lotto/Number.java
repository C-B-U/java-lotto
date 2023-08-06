package lotto;

public enum Number {
    ZERO(0),

    THOUSAND(1000),
    MIN_RANGE(1),
    MAX_RANGE(45),
    NUMBER_NUM(6);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int toValue() {
        return value;
    }
}
