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
}
