package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoService의 서비스 로직 중")
class LottoServiceTest {
    private LottoService lottoService = new LottoService(new LottoRepository());


    @Test
    @DisplayName("로또 저장 로직이 수행되는가")
    void saveLotto() {
        //given

        //when
        lottoService.saveLotto();

        //then

    }

    @Test
    @DisplayName("발행 번호 조회가 수행되는가")
    void getPublishNum() {
        //given

        //when
        final Integer publishNum = lottoService.getPublishNum(1000);

        //then
        assertThat(publishNum).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 티켓 발행이 수행되는가")
    void publishLottoTickets() {
        //given

        //when
        final List<LottoTicket> lottoTickets = lottoService.publishLottoTickets(1);

        //then
        assertThat(lottoTickets).hasSize(1);
    }

    @Test
    @DisplayName("당첨 번호 저장이 수행되는가")
    void saveWinningNumber() {
        //given

        //when
        final WinningNumber winningNumber = lottoService.saveWinningNumber(List.of(1, 2, 3, 4, 5, 6), 7);

        //then

    }
}
