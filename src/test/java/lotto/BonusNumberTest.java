package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("당첨 번호와 중복되는 보너스 번호")
    @Test
    void createBonusByDuplicatedWithWinning() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(List.of(1,2,3,4,5,6),"1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위 이탈하는 보너스 번호")
    @Test
    void createLottoByOverRangeBonus() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber(List.of(1,2,3,4,5,6),"47"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
