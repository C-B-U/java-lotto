package lotto;

import java.util.List;

public class LottoSystem {
    private final LottoCustomer lottoCustomer;
    private final LottoMarket lottoMarket;

    public LottoSystem(LottoCustomer lottoCustomer, LottoMarket lottoMarket) {
        this.lottoCustomer = lottoCustomer;
        this.lottoMarket = lottoMarket;
    }

    public void play() {
        int purchaseAmount = lottoCustomer.buyLotto();
        List<Lotto> lottos = lottoMarket.publishLotto(purchaseAmount);
        WinningLotto winningLotto = new WinningLotto(lottoCustomer.inputWinningNumbers(), lottoCustomer.inputBonusNumber());
        getResult(purchaseAmount, lottos, winningLotto);
    }

    // 이거를 LottoCustomer에 넣을지 LottoSystem에 넣을지 고민
    // 왜냐면 실질적으로 로또 결과를 요구하는 건 LottoCustomer같아서..ㅠㅠ
    public void getResult(int purchaseAmount, List<Lotto> lottos, WinningLotto winningLotto) {
        LottoCompare lottoCompare = new LottoCompare(lottos, winningLotto.getWinningNumbers(), winningLotto.getBonusNumber());
        ProfitCalculator profitCalculator = new ProfitCalculator(purchaseAmount, lottoCompare.getTotalAmount());
        OutputView outputView = new OutputView();
        outputView.printWinningStatistics(lottoCompare.getWinGames(), profitCalculator.getProfitRate());
    }
}
