package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnigLottoTest {

    @DisplayName("당첨 번호와 보너스 번호를 입력할 경우 당첨 로또가 생성된다.")
    @Test
    void createWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(10);
        assertThat(new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(WinningLotto.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복될 경 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(1);
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
