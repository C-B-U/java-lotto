package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateUnique(numbers);
    }

    private void validateUnique(final List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_UNIQUE_ELEMENTS.toString());
        }
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LottoNumberRange.NUMBER_NUM.toValue()) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.NOT_VALID_ELEMENTS_NUM.toString(), LottoNumberRange.NUMBER_NUM.toValue()));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
