package lotto.member.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void validateInputLottoAmount(String lottoAmount){
        validateInputNumber(lottoAmount);
        validateInputThousands(lottoAmount);
    }

    private static void validateInputThousands(String lottoAmount) {
        if(Integer.parseInt(lottoAmount) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 단위 입니다.");
        }
    }

    public void validateInputNumber(String number){
        final String regex = "^[0-9]+$";
        if (!number.matches(regex)){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 오로지 숫자입니다.");
        }
    }

    public void validateInputLottoNumber(List<Integer> numbers) {
        Set<Integer> numberCount = new HashSet<>(numbers);
        if (numberCount.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 6자리 수 입니다.");
        }
    }

    public void validateInputBonusNumber(String bonusNumber, List<Integer> winLottoNumber) {
        validateInputNumber(bonusNumber);
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        if (isNotNumberInRange(bonusNumberInt) && isNumberContainInList(bonusNumberInt, winLottoNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 당첨 번호에 포함되지 않는 숫자입니다.");
        }
    }

    private boolean isNotNumberInRange(int number){
        return number < 1 || number > 45;
    }

    private boolean isNumberContainInList(int bonusNumberInt, List<Integer> winLottoNumber){
        return winLottoNumber.contains(bonusNumberInt);
    }
}
