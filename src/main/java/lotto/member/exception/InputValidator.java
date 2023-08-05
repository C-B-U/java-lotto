package lotto.member.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void validateInputLottoAmount(Integer lottoAMount){
        if(lottoAMount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 단위 입니다.");
        }
    }

    public void validateInputLottoNumber(List<Integer> numbers) {
        Set<Integer> numberCount = new HashSet<>(numbers);
        if (numberCount.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6자리 수 입니다.");
        }
    }
}
