package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSixNumbers(numbers);
        checkNotDuplicated(numbers);
        checkInRange(numbers);
    }

    private void checkSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.toString());
        }
    }

     private void checkNotDuplicated(List<Integer> numbers) {
         if (numbers.size() != numbers.stream().distinct().count()) {
             throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.toString());
         }
     }

    private void checkInRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(n -> n <= 45 && n >= 1)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE_NUMBER.toString());
        }
    }
}
