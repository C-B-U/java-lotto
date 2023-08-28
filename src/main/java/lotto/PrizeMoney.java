package lotto;

public enum PrizeMoney {
    THREE_EQUAL_MONEY(5_000),
    FOUR_EQUAL_MONEY(50_000),
    FIVE_EQUAL_MONEY(1_500_000),
    BONUS_EQUAL_MONEY(30_000_000),
    SIX_EQUAL_MONEY(2_000_000_000);

    private final int number;

    PrizeMoney(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
