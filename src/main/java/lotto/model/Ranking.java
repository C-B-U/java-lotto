package lotto.model;

public enum Ranking {
    NONE(0, 0, false),
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final int prize;
    private final int matchNumber;
    private final boolean bonusMatch;

    Ranking(int prize, int matchNumber, boolean bonusMatch) {
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.bonusMatch = bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
