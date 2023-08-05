package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoGenerator {

    private final List<Integer> numbers;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    public RandomLottoGenerator() {
        this.numbers = generateRandomNumber();
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
    }

    public List<Integer> getRandomNumber() {
        return numbers;
    }
}
