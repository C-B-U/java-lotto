package lotto;

import lotto.member.repository.MemberRepository;
import lotto.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidTest {

    MemberService memberService = new MemberService();

    @Test
    @DisplayName("로또 구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void inputLottoAmountIsNotThousand(){
        assertThatThrownBy(() -> memberService.getLottoPrice("14500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 숫자가 아니면 예외가 발생한다.")
    void inputLottoAmountIsNotNumber(){
        assertThatThrownBy(() -> memberService.getLottoPrice("10000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호가 중복된 수를 입력하면 예외가 발생한다.")
    void inputWinLottoNumberIsDuplicate(){
        assertThatThrownBy(() -> memberService.getWinLottoNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호가 로또 숫자 범위안에 없으면 예외가 발생한다.")
    void inputWinLottoNumberNotInRange(){
        assertThatThrownBy(() -> memberService.getWinLottoNumber("1,2,100,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void inputBonusNumberIsNotNumber(){
        assertThatThrownBy(() -> memberService.getBonusNumber("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 로또 번호 범위에 없으면 예외가 발생한다.")
    void inputBonusNumberNotInRange(){
        assertThatThrownBy(() -> memberService.getBonusNumber("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있으면 예외가 발생한다.")
    void inputBonusNumberInWinLottoNumber(){
        MemberRepository memberRepository = new MemberRepository();
        List<Integer> winLottoNumber = memberService.getWinLottoNumber("1,2,3,4,5,6");

        for (Integer num : winLottoNumber){
            memberRepository.saveWinLottoNumber(num);
        }

        assertThatThrownBy(() -> memberService.getBonusNumber("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
