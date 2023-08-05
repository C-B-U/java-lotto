package lotto.lottoManager.repository;

import lotto.lottoManager.service.LottoStatistics;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoManagerRepository {
    private final Map<LottoStatistics, Integer> statisticsCounter = new EnumMap<>(LottoStatistics.class);

    public void upMatchCount(List<Integer> lottoNumber, List<Integer> winNumber, int bonusNumber) {
        int matchCount = getMatchCount(lottoNumber, winNumber);
        boolean isContainBonusNumber = isContainBonusNumber(winNumber, bonusNumber);
        resultMathThird(matchCount);
        resultMathFourth(matchCount);
        resultMathFifth(matchCount);
        resultMathFifthAndBonus(matchCount, isContainBonusNumber);
        resultMatchSIXTH(matchCount);
    }

    private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winNumber) {
        return (int) lottoNumbers.stream()
                .filter(winNumber::contains)
                .count();
    }

    private boolean isContainBonusNumber(List<Integer> winNumber, int bonusNumber){
        return winNumber.contains(bonusNumber);
    }


    private void resultMathThird(int matchCount) {
        if (matchCount == LottoStatistics.THIRD.getMatchCount()){
            statisticsCounter.put(LottoStatistics.THIRD, statisticsCounter.getOrDefault(LottoStatistics.THIRD, 0)+1);
        }
    }

    private void resultMathFourth(int matchCount){
        if(matchCount == LottoStatistics.FOURTH.getMatchCount()){
            statisticsCounter.put(LottoStatistics.FOURTH, statisticsCounter.getOrDefault(LottoStatistics.FOURTH, 0)+1);
        }
    }

    private void resultMathFifth(int matchCount){
        if(matchCount == LottoStatistics.FIFTH.getMatchCount()){
            statisticsCounter.put(LottoStatistics.FIFTH, statisticsCounter.getOrDefault(LottoStatistics.FIFTH, 0)+1);
        }
    }

    private void resultMathFifthAndBonus(int matchCount, boolean bonusNumber){
        if(matchCount == LottoStatistics.FIFTH_AND_BONUS.getMatchCount() && bonusNumber == LottoStatistics.FIFTH_AND_BONUS.isMatchBonus()){
            statisticsCounter.put(LottoStatistics.FIFTH_AND_BONUS, statisticsCounter.getOrDefault(LottoStatistics.FIFTH_AND_BONUS, 0)+1);
        }
    }

    private void resultMatchSIXTH(int matchCount){
        if(matchCount == LottoStatistics.SIXTH.getMatchCount()){
            statisticsCounter.put(LottoStatistics.SIXTH, statisticsCounter.getOrDefault(LottoStatistics.SIXTH, 0)+1);
        }
    }

    public Map<LottoStatistics, Integer> getStatisticsCounter() {
        return statisticsCounter;
    }
}
