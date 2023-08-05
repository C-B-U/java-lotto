package lotto.Model;

import java.util.Arrays;

public enum Ranking {

    NONE(0, 0, false),
    FIFTH(5000, 3, false),
    FOURTH(50000, 4, false),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int prize;
    private final int matchNumber;
    private final boolean isMatchBonus;

    Ranking(int prize, int matchNumber, boolean isMatchBonus) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.isMatchBonus = isMatchBonus;
    }

    public static Ranking calculate(int matchNumber, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchNumber == matchNumber)
                .filter(ranking -> ranking.isMatchBonus == isMatchBonus)
                .findAny()
                .orElse(NONE);
    }
}
