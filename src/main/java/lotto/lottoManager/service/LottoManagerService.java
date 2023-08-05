package lotto.lottoManager.service;

import lotto.lottoManager.repository.LottoManagerRepository;
import lotto.producer.repository.Lotto;

import java.util.List;

public class LottoManagerService {

    private final LottoManagerRepository lottoManagerRepository;

    public LottoManagerService(){
        this.lottoManagerRepository = new LottoManagerRepository();
    }

    public void getStatistics(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        // 비교를 한다.
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoManagerRepository.upMatchCount(lottoNumbers, winNumber, bonusNumber);
        }

    }
}
