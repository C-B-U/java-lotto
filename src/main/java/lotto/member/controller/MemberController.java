package lotto.member.controller;
import camp.nextstep.edu.missionutils.Console;
import lotto.member.service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(){
        this.memberService = new MemberService();
    }

    public int inputLottoAmount(){
        System.out.println("구입 금액을 입력해 주세요");
        return memberService.getLottoAmount(Console.readLine());
    }

    public List<Integer> inputWinLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요");
        return memberService.getWinLottoNumber(Console.readLine());
    }

    public int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return memberService.getBonusNumber(Console.readLine());
    }
}
