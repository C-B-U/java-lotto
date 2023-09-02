package lotto.repositroy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusLottoTest {
    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusLottoByOutOfRange() {
        assertThatThrownBy(() -> new BonusLotto(46, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 기존 6개의 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void createBonusLottoByDuplicated() {
        assertThatThrownBy(() -> new BonusLotto(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}