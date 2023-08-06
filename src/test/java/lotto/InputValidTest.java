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
}
