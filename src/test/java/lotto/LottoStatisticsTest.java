package lotto;

import lotto.lottoManager.repository.LottoManagerRepository;
import lotto.lottoManager.service.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

class LottoStatisticsTest {

    LottoManagerRepository lottoManagerRepository = new LottoManagerRepository();

    @DisplayName("로또 번호가 3개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountThree(){
        //given
        lottoManagerRepository.upMatchCount(List.of(1,2,3,4,5,6), List.of(9,7,3,2,1,10), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int mathThreeCount = resultStatistics.get(LottoStatistics.THIRD);

        //then
        assertThat(mathThreeCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 4개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountFour(){
        //given
        lottoManagerRepository.upMatchCount(List.of(1,2,3,4,5,6), List.of(6,7,3,2,1,10), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int mathThreeCount = resultStatistics.get(LottoStatistics.FOURTH);

        //then
        assertThat(mathThreeCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 5개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountFive(){
        //given
        lottoManagerRepository.upMatchCount(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,7), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int mathThreeCount = resultStatistics.get(LottoStatistics.FIFTH);

        //then
        assertThat(mathThreeCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 5개와 보너스 번호가 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountFiveAndBonusNumber(){
        //given
        lottoManagerRepository.upMatchCount(List.of(1,2,3,4,5,7), List.of(1,2,3,4,5,6), 6);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int mathThreeCount = resultStatistics.get(LottoStatistics.FIFTH_AND_BONUS);

        //then
        assertThat(mathThreeCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 6개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountSix(){
        //given
        lottoManagerRepository.upMatchCount(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int mathThreeCount = resultStatistics.get(LottoStatistics.SIXTH);

        //then
        assertThat(mathThreeCount).isEqualTo(1);

    }

}
