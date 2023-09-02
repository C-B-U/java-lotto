package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketServiceTest {
    private final LottoTicketService lottoTicketService = new LottoTicketService();

    @DisplayName("구매 금액을 1000원 단위로 입력하지 않으면 예외가 발생한다.")
    @Test
    void createLottoTicketsByInvalidMoneyUnit() {
        //given
        int testMoney = 1001;

        //when, then
        assertThatThrownBy(() -> lottoTicketService.createLottoTickets(testMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}