package lotto.member.controller;
import camp.nextstep.edu.missionutils.Console;
import lotto.member.service.MemberService;

public class MemberController {

    private final MemberService memberService;

    public MemberController(){
        this.memberService = new MemberService();
    }

    public int inputLottoAmount(){
        System.out.println("구입 금액을 입력해 주세요");
        return memberService.convertLottoAmount(Console.readLine());
    }
}
