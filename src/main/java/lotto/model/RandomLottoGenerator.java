package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator {

    private final Lotto numbers;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public RandomLottoGenerator() {
        this.numbers = generateRandomNumber();
    }

    private Lotto generateRandomNumber() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
    }

    public Lotto getRandomNumber() {
        return numbers;
    }
}
