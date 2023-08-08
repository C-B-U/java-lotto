package lotto.model;

public enum Constant {

    MAX_NUMBER(45),
    MIN_NUMBER(1),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private final Integer constant;

    Constant(Integer constant) {
        this.constant = constant;
    }

    public Integer getConstant() {
        return this.constant;
    }
}
