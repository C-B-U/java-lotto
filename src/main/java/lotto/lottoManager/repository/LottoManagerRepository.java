package lotto.lottoManager.repository;

import lotto.lottoManager.service.LottoStatistics;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoManagerRepository {
    private final Map<LottoStatistics, Integer> statisticsCounter = new EnumMap<>(LottoStatistics.class);

    public void upStatisticsMatchCount(List<Integer> lottoNumber, List<Integer> winNumber, int bonusNumber) {
        int matchCount = getMatchCount(lottoNumber, winNumber);
        boolean isMatchBonusNumber = isMatchBonusNumber(winNumber, bonusNumber);
        upMatchCount(matchCount, isMatchBonusNumber);
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winNumber) {
        return (int) lottoNumbers.stream()
                .filter(winNumber::contains)
                .count();
    }

    private boolean isMatchBonusNumber(List<Integer> winNumber, int bonusNumber){
        return winNumber.contains(bonusNumber);
    }

    private void upMatchCount(int matchCount, boolean isBonusNumberInWinNumber){
        for (LottoStatistics statistics : LottoStatistics.values()){
            if (matchCount == statistics.getMatchCount() && statistics.isMatchBonus() == isBonusNumberInWinNumber) {
                statisticsCounter.put(statistics, statisticsCounter.getOrDefault(statistics, 0)+1);
                break;
            }
        }
    }

    public double calculateLottoRate(int lottoPrice) {
        double lottoRevenue = 0;
        for (LottoStatistics statistics : LottoStatistics.values()){
            lottoRevenue += statistics.getPrice() * statisticsCounter.getOrDefault(statistics, 0);
        }
        double rate = (lottoRevenue / lottoPrice) * 100;
        return Math.round(rate * 100.0) / 100.0;
    }

    public Map<LottoStatistics, Integer> getStatisticsCounter() {
        return statisticsCounter;
    }

}
