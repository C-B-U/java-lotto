package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("범위를 벗어나는 보너스 숫자가 입력될 경우 오류가 발생한다.")
    @Test
    void bonusNumberRangeError() {
        assertThatThrownBy(() -> new BonusNumber(47))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
