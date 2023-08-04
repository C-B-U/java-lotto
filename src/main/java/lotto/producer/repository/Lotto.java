package lotto.producer.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numberCount = new HashSet<>(numbers);
        if (numberCount.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6자리 수 입니다.");
        }
    }

}
