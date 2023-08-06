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
        lottoManagerRepository.upStatisticsMatchCount(List.of(1,2,3,4,5,6), List.of(9,7,3,2,1,10), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int matchThirdCount = resultStatistics.get(LottoStatistics.THIRD);

        //then
        assertThat(matchThirdCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 4개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountFour(){
        //given
        lottoManagerRepository.upStatisticsMatchCount(List.of(1,2,3,4,5,6), List.of(6,7,3,2,1,10), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int matchFourthCount = resultStatistics.get(LottoStatistics.FOURTH);

        //then
        assertThat(matchFourthCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 5개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountFive(){
        //given
        lottoManagerRepository.upStatisticsMatchCount(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,7), 6);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int matchFifthCount = resultStatistics.get(LottoStatistics.FIFTH);

        //then
        assertThat(matchFifthCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 5개와 보너스 번호가 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountFiveAndBonusNumber(){
        //given
        lottoManagerRepository.upStatisticsMatchCount(List.of(1,2,3,4,5,7), List.of(1,2,3,4,5,6), 6);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int matchFifthAndBonusCount = resultStatistics.get(LottoStatistics.FIFTH_AND_BONUS);

        //then
        assertThat(matchFifthAndBonusCount).isEqualTo(1);

    }

    @DisplayName("로또 번호가 6개 일치하였을 때 개수가 올라가는지 확인한다.")
    @Test
    void matchLottoNumberCountSix(){
        //given
        lottoManagerRepository.upStatisticsMatchCount(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6), 45);
        Map<LottoStatistics, Integer> resultStatistics = lottoManagerRepository.getStatisticsCounter();

        //when
        int matchSixthCount = resultStatistics.get(LottoStatistics.SIXTH);

        //then
        assertThat(matchSixthCount).isEqualTo(1);

    }

    @DisplayName("로또 수익률 계산을 확인한다.")
    @Test
    void calculateLottoRate(){
        lottoManagerRepository.upStatisticsMatchCount(List.of(1,2,3,4,5,6), List.of(9,7,3,2,1,10), 45);

        double lottoRate =lottoManagerRepository.calculateLottoRate(8000);

        assertThat(lottoRate).isEqualTo(62.5);

    }

}
