package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoService의 서비스 로직 중")
class LottoServiceTest {
    private LottoRepository lottoRepository = new LottoRepository();
    private LottoService lottoService = new LottoService(lottoRepository);

    @Test
    @DisplayName("발행 번호 조회가 수행되는가")
    void getPublishNum() {
        //given

        //when
        final Integer publishNum = lottoService.savePublishNumber(1000);

        //then
        assertThat(publishNum).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 티켓 발행이 수행되는가")
    void publishLotto() {
        //given
        lottoService.savePublishNumber(1000);

        //when
        final List<Lotto> lottoList = lottoService.publishLotto();

        //then
        assertThat(lottoList).hasSize(1);
    }
}
