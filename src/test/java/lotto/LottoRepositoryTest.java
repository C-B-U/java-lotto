package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("LottoRepository 기능중")
class LottoRepositoryTest {
    private LottoRepository lottoRepository = new LottoRepository();

    @Test
    @DisplayName("Lotto 저장 기능이 수행되는가")
    void saveLotto() {
        //given

        //when
        lottoRepository.saveAllLotto(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));

        //then

    }

    @Test
    @DisplayName("WinningNumber 저장 기능이 수행되는가")
    void saveWinningNumber() {
        //given

        //when
        lottoRepository.saveWinningNumber(new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 7));

        //then

    }
}
