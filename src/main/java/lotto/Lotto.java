package lotto;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        // 여기 유효성 검사 메서드들을 뺄지 말지 고민..
        // 왜냐면 InputValidator랑 겹침 ㅠ
        validateDuplicateLottoNumber(numbers);
        validateSizeLottoNumber(numbers);
        validateRangeLottoNumber(numbers);
        this.numbers = numbers;
    }

    public void validateDuplicateLottoNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    public void validateSizeLottoNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRangeLottoNumber(List<Integer> numbers) {
        if (!(numbers.stream().allMatch(number -> number >= 1 && number <= 45))) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
