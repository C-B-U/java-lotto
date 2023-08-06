package lotto;

import java.util.Objects;

public class Result {
    private final RewardMoney rewardMoney;
    private final Integer matchNum;
    private final boolean isBonusMatch;

    public Result(final RewardMoney rewardMoney, final Integer matchNum, final boolean isBonusMatch) {
        this.rewardMoney = rewardMoney;
        this.matchNum = matchNum;
        this.isBonusMatch = isBonusMatch;
    }

    public RewardMoney getRewardMoney() {
        return this.rewardMoney;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Result result = (Result) o;
        return isBonusMatch == result.isBonusMatch && rewardMoney == result.rewardMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardMoney, isBonusMatch);
    }
}
