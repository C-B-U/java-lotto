package lotto.model;

import java.util.Arrays;

public enum Ranking {
    NONE(0, 0, false, null),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - %d개"),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - %d개"),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - %d개"),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - %d개");

    private final int prize;
    private final int matchNumber;
    private final boolean isMatchBonus;
    private final String message;

    Ranking(int prize, int matchNumber, boolean isMatchBonus, String message) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.isMatchBonus = isMatchBonus;
        this.message = message;
    }

    public static Ranking calculate(int matchNumber, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchNumber == matchNumber)
                .filter(ranking -> ranking.isMatchBonus == isMatchBonus)
                .findAny()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage(int result) {
        return String.format(message, result);
    }
}
