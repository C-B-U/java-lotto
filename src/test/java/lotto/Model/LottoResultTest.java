package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

public class LottoResultTest {

    PlayerLottoes playerLottoes = mock(PlayerLottoes.class);

    @DisplayName("겹치는 숫자가 0개 ~ 2개일 경우 당첨이 아니다.")
    @Test
    void checkRankingNone() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        given(playerLottoes.getLottoes()).willReturn(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(7,8,9,10,11,12)), new BonusNumber(45));

        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();

        assertThat(lottoResult.getRankingsResult().get(Ranking.NONE)).isEqualTo(1);
    }

    @DisplayName("겹치는 숫자가 3개일 경우 5등 당첨")
    @Test
    void checkRankingFifth() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        given(playerLottoes.getLottoes()).willReturn(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,7,8,9)), new BonusNumber(4));

        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();

        assertThat(lottoResult.getRankingsResult().get(Ranking.FIFTH)).isEqualTo(1);
    }

    @DisplayName("겹치는 숫자가 4개일 경우 4등 당첨")
    @Test
    void checkRankingFourth() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        given(playerLottoes.getLottoes()).willReturn(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,8,9)), new BonusNumber(5));

        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();

        assertThat(lottoResult.getRankingsResult().get(Ranking.FOURTH)).isEqualTo(1);
    }

    @DisplayName("겹치는 숫자가 5개이고 보너스 번호가 겹치지 않을 경우 3등 당첨")
    @Test
    void checkRankingThird() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        given(playerLottoes.getLottoes()).willReturn(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,9)), new BonusNumber(45));

        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();

        assertThat(lottoResult.getRankingsResult().get(Ranking.THIRD)).isEqualTo(1);
    }

    @DisplayName("겹치는 숫자가 5개이고 보너스 번호가 겹칠 경우 3등 당첨")
    @Test
    void checkRankingSecond() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        given(playerLottoes.getLottoes()).willReturn(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,8)), new BonusNumber(6));

        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();

        assertThat(lottoResult.getRankingsResult().get(Ranking.SECOND)).isEqualTo(1);
    }

    @DisplayName("겹치는 숫자가 6개일 경우 1등 당첨")
    @Test
    void checkRankingFirst() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        given(playerLottoes.getLottoes()).willReturn(List.of(lotto));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), new BonusNumber(10));

        LottoResult lottoResult = new LottoResult(winningLotto, playerLottoes);
        lottoResult.calculateWinningRank();

        assertThat(lottoResult.getRankingsResult().get(Ranking.FIRST)).isEqualTo(1);
    }
}
