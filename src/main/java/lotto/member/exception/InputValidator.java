package lotto.member.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void validateInputLottoPrice(String lottoPrice){
        validateInputNumber(lottoPrice);
        validateInputThousands(lottoPrice);
    }

    private static void validateInputThousands(String lottoPrice) {
        if(Integer.parseInt(lottoPrice) % LottoRule.PRICE_UNIT.getValue() != 0){
            throw new IllegalArgumentException(InputErrorMessage.INPUT_THOUSAND.getMessage());
        }
    }

    public void validateInputNumber(String number){
        final String regex = "^[0-9]+$";
        if (!number.matches(regex)){
            throw new IllegalArgumentException(InputErrorMessage.INPUT_NUMBER.getMessage());
        }
    }

    public void validateInputLottoNumber(List<Integer> winLottoNumbers) {
        Set<Integer> finalLottoNumber = new HashSet<>(winLottoNumbers);
        if (finalLottoNumber.size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(InputErrorMessage.INPUT_NOT_DUPLICATE_AND_SIX.getMessage());
        }
    }

    public void validateInputBonusNumber(String bonusNumber, List<Integer> winLottoNumber) {
        validateInputNumber(bonusNumber);
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        if (isNotNumberInRange(bonusNumberInt) || isNumberContainInList(bonusNumberInt, winLottoNumber)){
            throw new IllegalArgumentException(InputErrorMessage.INPUT_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isNotNumberInRange(int number){
        return number < LottoRule.START_NUMBER.getValue() || number > LottoRule.END_NUMBER.getValue();
    }

    private boolean isNumberContainInList(int bonusNumberInt, List<Integer> winLottoNumber){
        return winLottoNumber.contains(bonusNumberInt);
    }
}
