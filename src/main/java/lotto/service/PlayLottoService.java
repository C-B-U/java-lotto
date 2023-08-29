package lotto.service;


import lotto.dto.AllLottoes;
import lotto.repositroy.BonusLotto;
import lotto.repositroy.Lotto;

import java.util.List;

public class PlayLottoService {
    private static final int HUNDRED = 100;
    private final OutcomeService outcomeService;

    public PlayLottoService() {
        this.outcomeService = new OutcomeService();
    }

    public AllLottoes setAllLottoes(List<Integer> lottoAnswers, int bonusAnswer) {
        Lotto lotto = new Lotto(lottoAnswers);
        BonusLotto bonusLotto = new BonusLotto(bonusAnswer, lotto.getNumbers());
        return new AllLottoes(lotto, bonusLotto);
    }

    public long playLotto(AllLottoes allLottoes, List<List<Integer>> tickets) {
        return outcomeService.getTotalPrizeMoney(allLottoes, tickets);
    }

    public void printEarningRate(double earningRate) {
        String earningPercent = String.format("%.1f", earningRate * HUNDRED);
        System.out.println(OutputGuide.TOTAL_EARNING_FRONT.getContent() + earningPercent
                + OutputGuide.TOTAL_EARNING_BACK.getContent());
    }
}
