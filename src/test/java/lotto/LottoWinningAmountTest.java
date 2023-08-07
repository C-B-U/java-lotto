package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoWinningAmountTest {
    @DisplayName("1등 당첨")
    @Test
    void caseFirstGrade() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,5,6)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        long result = 2_000_000_000;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getTotalAmount()).isEqualTo(result);
    }

    @DisplayName("2등 당첨 (보너스 번호 일치)")
    @Test
    void caseSecondGrade() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,5,7)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        long result = 30_000_000;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getTotalAmount()).isEqualTo(result);
    }

    @DisplayName("3등 당첨")
    @Test
    void caseThirdGrade() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,5,9)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        long result = 1_500_000;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getTotalAmount()).isEqualTo(result);
    }

    @DisplayName("4등 당첨")
    @Test
    void caseFourthGrade() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,4,8,9)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        long result = 50_000;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getTotalAmount()).isEqualTo(result);
    }

    @DisplayName("5등 당첨")
    @Test
    void caseFifthGrade() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,3,8,9,10)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        long result = 5_000;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getTotalAmount()).isEqualTo(result);
    }

    @DisplayName("미당첨")
    @Test
    void caseNonGrade() {
        List<Lotto> lottos = List.of(
                new Lotto(List.<Integer>of(1,2,11,8,9,10)),
                new Lotto(List.<Integer>of(7,8,9,10,11,12)),
                new Lotto(List.<Integer>of(13,14,15,16,17,18)),
                new Lotto(List.<Integer>of(19,20,21,22,23,24)),
                new Lotto(List.<Integer>of(25,26,27,28,29,30))
        );
        List<Integer> winningNumbers = List.<Integer>of(1,2,3,4,5,6);
        int bonusNumber = 7;
        long result = 0;
        LottoCompare lottoCompare = new LottoCompare(lottos, winningNumbers, bonusNumber);
        assertThat(lottoCompare.getTotalAmount()).isEqualTo(result);
    }
}
