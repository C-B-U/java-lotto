package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumerTest {
    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("당첨번호 길이 초과")
    @Test
    void createOverLengthWinningNumbers() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 범위 초과")
    @Test
    void createOverRangeWinningNumbers() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers(List.of(1,2,3,4,5,50)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
