package lotto.service;

import lotto.PrizeMoney;
import lotto.PrizeResult;
import lotto.dto.AllLottoes;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutcomeService {
    DecimalFormat formatter = new DecimalFormat("#,###");

    private final PrizeResult prizeResult;

    public OutcomeService() {
        this.prizeResult = new PrizeResult();
    }

    public long getTotalPrizeMoney(final AllLottoes allLottoes, final List<List<Integer>> tickets) {
        prizeResult.initialize();
        prizeResult.makeResult(allLottoes, tickets);
        printResult();

        return calculateTotalMoney();
    }


    private void printResult() {
        Map<MatchNum, PrizeMoney> prizeMoneyMap = prizeResult.getPrizeMoneyMap();
        Map<MatchNum, Integer> playResult = prizeResult.getPlayResult();
        System.out.println(OutputGuide.RESULT_STATISTICS.getContent());
        Arrays.stream(MatchNum.values()).forEach(m -> {
            printEqualNum(m);
            printPrizeMoney(prizeMoneyMap.get(m));
            printLottoNumResult(playResult.get(m));
        });
    }


    private void printEqualNum(MatchNum matchNum) {
        if (matchNum.equals(MatchNum.BONUS_MATCH)) {
            System.out.print(OutputGuide.BONUS_NUM_GUIDE.getContent());
            return;
        }
        System.out.print(matchNum.getNum() + OutputGuide.EQUAL_NUM_GUIDE.getContent());
    }

    private void printPrizeMoney(PrizeMoney prizeMoney) {
        String formatMoney = formatter.format(prizeMoney.getNumber());
        System.out.print(formatMoney + OutputGuide.PRIZE_MONEY_GUIDE.getContent());
    }


    private void printLottoNumResult(Integer result) {
        System.out.println(result + OutputGuide.LOTTO_NUM.getContent());
    }


    private long calculateTotalMoney() {
        long totalMoney = 0;
        Map<MatchNum, PrizeMoney> prizeMoneyMap = prizeResult.getPrizeMoneyMap();
        Map<MatchNum, Integer> playResult = prizeResult.getPlayResult();

        for (MatchNum matchNum : MatchNum.values()) {
            totalMoney += prizeMoneyMap.get(matchNum).getNumber() * playResult.get(matchNum).longValue();
        }
        return totalMoney;
    }

}
