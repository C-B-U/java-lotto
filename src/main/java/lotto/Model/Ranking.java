package lotto.Model;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    NONE(0, 0, List.of(true, false), null),
    FIFTH(5000, 3, List.of(true, false), "3개 일치 (5,000원) - %d개"),
    FOURTH(50000, 4, List.of(true, false), "4개 일치 (50,000원) - %d개"),
    THIRD(1500000, 5, List.of(false), "5개 일치 (1,500,000원) - %d개"),
    SECOND(30000000, 5, List.of(true), "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(2000000000, 6, List.of(true, false), "6개 일치 (2,000,000,000원) - %d개");

    private final int prize;
    private final int matchNumber;
    private final List<Boolean> isMatchBonus;
    private final String message;

    Ranking(int prize, int matchNumber, List<Boolean> isMatchBonus, String message) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.isMatchBonus = isMatchBonus;
        this.message = message;
    }

    public static Ranking calculate(int matchNumber, boolean isMatchBonus) {
        return Arrays.stream(values())
                .filter(ranking -> ranking.matchNumber == matchNumber)
                .filter(ranking -> ranking.isMatchBonus.contains(isMatchBonus))
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
