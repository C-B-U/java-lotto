package lotto.member.service;

import lotto.member.repository.MemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(){
        this.memberRepository = new MemberRepository();
    }

    public int convertLottoAmount(String lottoAmount){
        return Integer.parseInt(lottoAmount);
    }


}
