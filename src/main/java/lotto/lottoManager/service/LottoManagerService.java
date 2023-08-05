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
        // 결과를 출력한다.
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.print(lottoManagerRepository.getMatchResult());
    }

    public void getLottoRate(int lottoAmount) {
        System.out.print("총 수익률은 " + lottoManagerRepository.getLottoRate(lottoAmount) + "%입니다.");
    }
}
