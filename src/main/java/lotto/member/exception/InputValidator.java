package lotto.member.exception;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    public void validateInputLottoPrice(String lottoPrice){
        validateInputNumber(lottoPrice);
        validateInputThousands(lottoPrice);
    }

    private static void validateInputThousands(String lottoPrice) {
        if(Integer.parseInt(lottoPrice) % LottoRule.PRICE_UNIT.getValue() != 0){
            throw new IllegalArgumentException(InputErrorMessage.THOUSAND.getMessage());
        }
    }

    public void validateInputNumber(String number){
        final String regex = "^[0-9]+$";
        if (!number.matches(regex)){
            throw new IllegalArgumentException(InputErrorMessage.NUMBER.getMessage());
        }
    }

    public void validateInputLottoNumber(List<Integer> winLottoNumbers) {
        Set<Integer> finalLottoNumber = winLottoNumbers.stream()
                .peek(this::validateNumberInRange)
                .collect(Collectors.toSet());
        if (finalLottoNumber.size() != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException(InputErrorMessage.NOT_DUPLICATE_AND_SIX.getMessage());
        }
    }

    public void validateInputBonusNumber(String bonusNumber, List<Integer> winLottoNumber) {
        validateInputNumber(bonusNumber);
        validateNumberInRange(Integer.parseInt(bonusNumber));
        validateNumberContainInList(Integer.parseInt(bonusNumber),winLottoNumber);
    }

    private void validateNumberInRange(int number){
        if(number < LottoRule.START_NUMBER.getValue() || number > LottoRule.END_NUMBER.getValue()){
            throw new IllegalArgumentException(InputErrorMessage.IN_NUMBER_RANGE.getMessage());
        }
    }

    private void validateNumberContainInList(int bonusNumberInt, List<Integer> winLottoNumber){
        if(winLottoNumber.contains(bonusNumberInt)){
            throw new IllegalArgumentException(InputErrorMessage.IN_WIN_LOTTO_NUMBER.getMessage());
        }
    }
}
