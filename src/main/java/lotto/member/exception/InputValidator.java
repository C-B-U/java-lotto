package lotto.member.exception;

public class InputValidator {

    public void validateInputLottoAmount(Integer lottoAMount){
        if(lottoAMount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000 단위 입니다.");
        }
    }
}
