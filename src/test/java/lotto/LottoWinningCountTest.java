package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoWinningCountTest {
    @DisplayName("1등 1개 당첨")
    @Test
    void caseFirstGradeCount() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,5,6)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getWinGames().get(WinningGrade.FIRST)).isEqualTo(1);
    }

    @DisplayName("2등 2개 당첨")
    @Test
    void caseSecondGradeCount() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,5,7)),
                new Lotto(List.<Integer>of(1,2,3,4,5,7)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getWinGames().get(WinningGrade.SECOND)).isEqualTo(2);
    }

    @DisplayName("3등 3개 당첨")
    @Test
    void caseThirdGradeCount() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,5,8)),
                new Lotto(List.<Integer>of(1,2,3,4,5,8)),
                new Lotto(List.<Integer>of(1,2,3,4,5,8)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getWinGames().get(WinningGrade.THIRD)).isEqualTo(3);
    }

    @DisplayName("4등 4개 당첨")
    @Test
    void caseFourthGradeCount() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,9,8)),
                new Lotto(List.<Integer>of(1,2,3,4,9,8)),
                new Lotto(List.<Integer>of(1,2,3,4,9,8)),
                new Lotto(List.<Integer>of(1,2,3,4,9,8)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getWinGames().get(WinningGrade.FOURTH)).isEqualTo(4);
    }

    @DisplayName("5등 5개 당첨")
    @Test
    void caseFifthGradeCount() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,8,9,10)),
                new Lotto(List.<Integer>of(1,2,3,8,9,10)),
                new Lotto(List.<Integer>of(1,2,3,8,9,10)),
                new Lotto(List.<Integer>of(1,2,3,8,9,10)),
                new Lotto(List.<Integer>of(1,2,3,8,9,10))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getWinGames().get(WinningGrade.FIFTH)).isEqualTo(5);
    }
}
