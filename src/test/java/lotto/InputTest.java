package lotto;

import lotto.view.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final InputValidator inputValidator = new InputValidator();

    @DisplayName("구매 금액 입력에 숫자가 아닌 입력을 하면 오류가 발생한다.")
    @Test
    void purchaseAmountError() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("보너스 숫자 입력에 숫자가 아닌 입력을 하면 오류가 발생한다.")
    @Test
    void bonusNumberError() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("범위를 벗어나는 보너스 숫자가 입력될 경우 오류가 발생한다.")
    @Test
    void bonusNumberRangeError() {
        assertThatThrownBy(() -> inputValidator.validateBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("콤마 이외의 구분자로 숫자를 구분할 경우 예외가 발생한다.")
    @Test
    void winningNumberSplitError() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1 2 3 4 5 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
