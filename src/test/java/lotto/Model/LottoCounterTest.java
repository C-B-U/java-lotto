package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCounterTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("금액을 입력하면 금액에 맞는 로또 개수를 반환한다.")
    @Test
    void createLottoTickets() {
        LottoCounter lottoCounter = new LottoCounter(8000);
        assertThat(lottoCounter.getLotteryTicket()).isEqualTo(8);
    }

    @DisplayName("구매 금액이 천원 단위가 아닌 경우 오류가 발생한다.")
    @Test
    void purchaseAmountError() {
        assertThatThrownBy(() -> new LottoCounter(1550))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
