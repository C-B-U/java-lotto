package lotto.Model;

public enum Ranking {

    NONE(0, 0, false),
    FIFTH(5000, 3, false),
    FOURTH(50000, 4, false),
    THIRD(1500000, 5, false),
    SECOND(30000000, 5, true),
    FIRST(2000000000, 6, false);

    private final int prize;
    private final int matchNumber;
    private final boolean matchBonus;

    Ranking(int prize, int matchNumber, boolean matchBonus) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.matchBonus = matchBonus;
    }
}
