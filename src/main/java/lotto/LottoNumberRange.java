package lotto;

public enum LottoNumberRange {
    MIN_RANGE(1),
    MAX_RANGE(45),
    NUMBER_NUM(6);
    private final int value;

    LottoNumberRange(int value) {
        this.value = value;
    }

    public int toValue() {
        return value;
    }
}
