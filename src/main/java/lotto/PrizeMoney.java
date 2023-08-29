package lotto;

public enum PrizeMoney {
    THREE_EQUAL_MONEY(5_000L),
    FOUR_EQUAL_MONEY(50_000L),
    FIVE_EQUAL_MONEY(1_500_000L),
    BONUS_EQUAL_MONEY(30_000_000L),
    SIX_EQUAL_MONEY(2_000_000_000L);

    private final long number;

    PrizeMoney(final long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

}
