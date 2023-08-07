package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_QUANTITY = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "\n당첨통계\n---";
    private static final int LOTTO_PRICE = 1000;

    public int printPurchaseQuantity(int purchaseAmount) {
        int purchaseQuantity = purchaseAmount/LOTTO_PRICE;
        System.out.printf((PURCHASE_QUANTITY), purchaseQuantity);
        return purchaseQuantity;
    }
    public void printLotto(List<Lotto> lottoNumbers) {
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningStatistics(Map<WinningGrade, Integer> winGames, String profitRate) {
        System.out.println(WINNING_STATISTICS);
        getWinningStatistics(winGames);
        getProfitRate(profitRate);
    }

    private static void getWinningStatistics(Map<WinningGrade, Integer> winGames) {
        winGames.forEach((grade, count) -> {
            String reward = getReward(grade, count);
            System.out.println(reward);
        });
    }

    private static String getReward(WinningGrade grade, int count) {
        if (grade == WinningGrade.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", grade.getWinningNumberCount(), convertDecimalFormat(
                    grade.getWinningAmount()), count);
        }
        return String.format("%d개 일치 (%s원) - %d개", grade.getWinningNumberCount(), convertDecimalFormat(
                grade.getWinningAmount()), count);
    }

    private static String convertDecimalFormat(int cashPrize) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(cashPrize);
    }

    private static void getProfitRate(String profitRate) {
        String totalProfitRate = String.format("총 수익률은 %s%%입니다.", profitRate);
        System.out.println(totalProfitRate);
    }
}
