package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfitRateTest {
    @DisplayName("투입금액보다 상금이 적을때")
    @Test
    void calculateProfitRateTest() {
        int money = 8000;
        long totalCashPrize = 5000;
        ProfitCalculator profitCalculator = new ProfitCalculator(money, totalCashPrize);
        String result = "62.5";

        assertThat(profitCalculator.getProfitRate()).isEqualTo(result);
    }

    @DisplayName("투입금액보다 상금이 많을때")
    @Test
    void calculateProfitRateTest2() {
        int money = 6000;
        long totalCashPrize = 55000;
        ProfitCalculator profitCalculator = new ProfitCalculator(money, totalCashPrize);
        String result = "916.7";

        assertThat(profitCalculator.getProfitRate()).isEqualTo(result);
    }

    @DisplayName("상금이 없을때")
    @Test
    void calculateProfitRateTest3() {
        int money = 6000;
        long totalCashPrize = 0;
        ProfitCalculator profitCalculator = new ProfitCalculator(money, totalCashPrize);
        String result = "0.0";

        assertThat(profitCalculator.getProfitRate()).isEqualTo(result);
    }
}
