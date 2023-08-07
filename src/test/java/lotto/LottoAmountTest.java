package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("1000원 단위가 아닌 금액 입력")
    @Test
    void inputThousandWonUnit() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 금액 입력")
    @Test
    void inputNotNumberAmount() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("adsf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백이 들어간 금액 입력")
    @Test
    void inputAmountWithBlank() {
        assertThatThrownBy(() -> inputValidator.validatePurchaseAmount("  3000   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
