package lotto.Model;

import lotto.view.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            ExceptionMessage message = ExceptionMessage.INCORRECT_LOTTO_SIZE;
            throw new IllegalArgumentException(message.toString());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numberToSet = new HashSet<>(numbers);
        if (numberToSet.size() != LOTTO_SIZE) {
            ExceptionMessage message = ExceptionMessage.DUPLICATE_NUMBER;
            throw new IllegalArgumentException(message.toString());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::isCorrectRange);
    }
    private void isCorrectRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
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
