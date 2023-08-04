package lotto.member.service;

import lotto.member.exception.InputValidator;
import lotto.member.repository.MemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;
    private final InputValidator inputValidator;

    public MemberService(){
        this.memberRepository = new MemberRepository();
        this.inputValidator = new InputValidator();
    }

    public int convertLottoAmount(String lottoAmount){
        int lottoAmountInt = Integer.parseInt(lottoAmount);
        inputValidator.validateInputLottoAmount(lottoAmountInt);
        return lottoAmountInt;
    }


}
