package lotto.lottoManager.service;

import lotto.lottoManager.repository.LottoManagerRepository;
import lotto.producer.repository.Lotto;

import java.util.List;
import java.util.Map;

public class LottoManagerService {

    private final LottoManagerRepository lottoManagerRepository;

    public LottoManagerService(){
        this.lottoManagerRepository = new LottoManagerRepository();
    }

    public void getStatistics(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoManagerRepository.upStatisticsMatchCount(lottoNumbers, winNumber, bonusNumber);
        }
        System.out.println(getMatchResult());
    }

    public String getMatchResult() {
        Map<LottoStatistics, Integer> statisticsCounter = lottoManagerRepository.getStatisticsCounter();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n")
                .append("당첨 통계\n")
                .append("---\n");
        for (LottoStatistics statistics : LottoStatistics.values()){
            stringBuilder.append(statistics)
                    .append(statisticsCounter.getOrDefault(statistics, 0))
                    .append("개\n");
        }
        return stringBuilder.toString();
    }

    public void getLottoRate(int lottoPrice) {
        String printLottoRate = "총 수익률은 " +
                lottoManagerRepository.calculateLottoRate(lottoPrice) +
                "%입니다.";
        System.out.println(printLottoRate);
    }

}
