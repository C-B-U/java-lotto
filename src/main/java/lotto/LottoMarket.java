package lotto;

import java.util.List;

public class LottoMarket {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final OutputView outputView = new OutputView();

    public List<Lotto> publishLotto(int purchaseAmount) {
        int purchaseQuantity = outputView.printPurchaseQuantity(purchaseAmount);
        return lottoGenerator.generateLottoNumbers(purchaseQuantity);
    }
}
