package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE.getConstant()) {
            ExceptionMessage message = ExceptionMessage.INCORRECT_LOTTO_SIZE;
            throw new IllegalArgumentException(message.toString());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberToSet = new HashSet<>(numbers);
        if (numberToSet.size() != Constant.LOTTO_SIZE.getConstant()) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_NUMBER;
            throw new IllegalArgumentException(message.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::isCorrectRange);
    }
    private void isCorrectRange(int number) {
        int maxNumber = Constant.MAX_NUMBER.getConstant();
        int minNumber = Constant.MIN_NUMBER.getConstant();
        if (!(minNumber <= number && number <= maxNumber)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }
}
