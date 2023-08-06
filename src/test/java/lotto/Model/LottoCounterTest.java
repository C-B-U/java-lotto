package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoCounterTest {

    @DisplayName("금액을 입력하면 금액에 맞는 로또 개수를 반환한다.")
    @Test
    void createLottoTickets() {
        LottoCounter lottoCounter = new LottoCounter(8000);
        assertThat(lottoCounter.getLotteryTicket()).isEqualTo(8);
    }
}
