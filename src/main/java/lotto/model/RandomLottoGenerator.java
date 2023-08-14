package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator {

    private final Lotto numbers;

    public RandomLottoGenerator() {
        this.numbers = generateRandomNumber();
    }

    private Lotto generateRandomNumber() {
        int maxNumber = Constant.MAX_NUMBER.getConstant();
        int minNumber = Constant.MIN_NUMBER.getConstant();
        int lottoSize  = Constant.LOTTO_SIZE.getConstant();
        return new Lotto(Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, lottoSize));
    }

    public Lotto getRandomNumber() {
        return numbers;
    }
}
