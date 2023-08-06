package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket(final List<Integer> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
