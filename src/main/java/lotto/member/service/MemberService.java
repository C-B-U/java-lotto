package lotto.member.service;

import lotto.member.exception.InputValidator;
import lotto.member.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MemberService {

    private final MemberRepository memberRepository;
    private final InputValidator inputValidator;

    public MemberService(){
        this.memberRepository = new MemberRepository();
        this.inputValidator = new InputValidator();
    }

    public int getLottoAmount(String lottoAmount){
        return convertLottoAmount(lottoAmount);
    }

    private int convertLottoAmount(String lottoAmount){
        int lottoAmountInt = Integer.parseInt(lottoAmount);
        inputValidator.validateInputLottoAmount(lottoAmountInt);
        return lottoAmountInt;
    }

    public List<Integer> getWinLottoNumber(String winNumber){
        for (Integer integer : convertWinLottoNumber(winNumber)) {
            memberRepository.save(integer);
        }
        return memberRepository.getWinLottoNumber();
    }

    private List<Integer> convertWinLottoNumber(String winNumber) {
        List<Integer> winNumberIntList = winNumber.chars()
                .filter(Character::isDigit)
                .mapToObj(c -> Character.getNumericValue((char)c))
                .collect(Collectors.toList());
        inputValidator.validateInputLottoNumber(winNumberIntList);
        return winNumberIntList;
    }

    public int getBonusNumber(String bonusNumber) {
        int bonusNumberInt = convertBonusNumber(bonusNumber);
        memberRepository.saveBonusNumber(bonusNumberInt);
        return memberRepository.getBonusNumber();
    }

    private int convertBonusNumber(String bonusNumber){
        int bonusNumberInt = Integer.parseInt(bonusNumber);
        List<Integer> winLottoNumber = memberRepository.getWinLottoNumber();
        inputValidator.validateInputBonusNumber(bonusNumberInt, winLottoNumber);
        return bonusNumberInt;
    }
}
