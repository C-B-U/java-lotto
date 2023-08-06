package lotto;

import lotto.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
