package lotto.service;


public enum MatchNum {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    BONUS_MATCH(7),
    SIX_MATCH(6);

    private final int num;

    MatchNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static MatchNum getOf(int check) {
        for (MatchNum matchNum : MatchNum.values()) {
            if (check == matchNum.getNum()) {
                return matchNum;
            }
        }
        return null;
    }

}
