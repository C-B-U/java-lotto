package lotto.service;


import lotto.PrizeResult;
import lotto.dto.AllLottoes;
import lotto.repositroy.BonusLotto;
import lotto.repositroy.Lotto;

import java.util.List;
import java.util.Map;

public class PlayLottoService {
    private final OutcomeService outcomeService;

    public PlayLottoService() {
        this.outcomeService = new OutcomeService();
    }

    public AllLottoes setAllLottoes(List<Integer> lottoAnswers, int bonusAnswer) {
        Lotto lotto = new Lotto(lottoAnswers);
        BonusLotto bonusLotto = new BonusLotto(bonusAnswer, lotto.getNumbers());
        return new AllLottoes(lotto, bonusLotto);
    }

    public void playLotto(AllLottoes allLottoes, List<List<Integer>> tickets) {
        long totalMoney = outcomeService.getTotalPrizeMoney(allLottoes, tickets);
    }
}
