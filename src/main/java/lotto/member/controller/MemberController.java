package lotto.member.controller;
import camp.nextstep.edu.missionutils.Console;
import lotto.member.service.MemberService;

import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(){
        this.memberService = new MemberService();
    }

    public int inputLottoPrice(){
        System.out.println(InputMessage.PURCHASE.getMessage());
        return memberService.getLottoPrice(Console.readLine());
    }

    public List<Integer> inputWinLottoNumber(){
        System.out.println(InputMessage.WIN_NUMBER.getMessage());
        return memberService.getWinLottoNumber(Console.readLine());
    }

    public int inputBonusNumber(){
        System.out.print(InputMessage.ENTER.getMessage());
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
        return memberService.getBonusNumber(Console.readLine());
    }
}
