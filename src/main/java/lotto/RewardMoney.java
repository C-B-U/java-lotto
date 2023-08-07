package lotto;

public enum RewardMoney {
    THREE_MATCH(5_000L),
    FOUR_MATCH(50_000L),
    FIVE_MATCH(1_500_000L),
    MATCH_WITH_BONUS(30_000_000L),
    SIX_MATCH(2_000_000_000L),
    NONE(0L);

    private final Long money;

    RewardMoney(final Long money) {
        this.money = money;
    }

    public Long toValue() {
        return this.money;
    }
}
