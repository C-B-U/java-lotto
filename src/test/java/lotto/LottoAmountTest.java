package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {

    @DisplayName("1000원 단위가 아닌 금액 입력")
    @Test
    void inputThousandWonUnit() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 금액 입력")
    @Test
    void inputNotNumberAmount() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("adsf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백이 들어간 금액 입력")
    @Test
    void inputAmountWithBlank() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("  3000   "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
