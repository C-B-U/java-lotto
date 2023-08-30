package lotto.repositroy;

public enum LottoRangeNumber {
    MIN_LOTTO_NUM(1),
    MAX_LOTTO_NUM(45),
    NUM_OF_LOTTO_NUMS(6);

    private int num;

    LottoRangeNumber(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
