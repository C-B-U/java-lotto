package lotto;

import lotto.dto.AllLottoes;
import lotto.repositroy.BonusLotto;
import lotto.service.MatchNum;

import java.util.*;

public class PrizeResult {
    private static final int ZERO = 0;
    private final Map<MatchNum, Integer> playResult = new EnumMap<>(MatchNum.class);
    private final Map<MatchNum, PrizeMoney> prizeMoneyMap = new EnumMap<>(MatchNum.class);

    public void initialize() {
        initializePlayResult();
        initializePrizeMoneyMap();
    }

    private void initializePlayResult() {
        Arrays.stream(MatchNum.values()).distinct().forEach(m -> playResult.put(m, ZERO));
    }

    private void initializePrizeMoneyMap() {
        Iterator<PrizeMoney> prizeMoneyIterator = Arrays.stream(PrizeMoney.values()).iterator();
        for (MatchNum matchNum : MatchNum.values()) {
            prizeMoneyMap.put(matchNum, prizeMoneyIterator.next());
        }
    }

    public void makeResult(AllLottoes allLottoes, List<List<Integer>> tickets) {
        for (List<Integer> ticket : tickets) {
            MatchNum match = checkTicket(ticket, allLottoes);
            playResult.put(match, playResult.get(match) + 1);
        }
    }

    private MatchNum checkTicket(List<Integer> ticket, AllLottoes allLottoes) {
        int count = (int) ticket.stream().filter(num -> allLottoes.getLotto().getNumbers().contains(num)).count();
        if (count == MatchNum.FIVE_MATCH.getNum()) {
            return checkBonusLotto(ticket, allLottoes.getBonusLotto());
        }
        return MatchNum.valueOf(count);
    }

    private MatchNum checkBonusLotto(List<Integer> ticket, BonusLotto bonusLotto) {
        if (isBonusLotto(ticket, bonusLotto)) {
            return MatchNum.BONUS_MATCH;
        }
        return MatchNum.FIVE_MATCH;
    }

    private boolean isBonusLotto(List<Integer> ticket, BonusLotto bonusLotto) {
        return ticket.contains(bonusLotto.getNumber());
    }

    public Map<MatchNum, Integer> getPlayResult() {
        return playResult;
    }

    public Map<MatchNum, PrizeMoney> getPrizeMoneyMap() {
        return prizeMoneyMap;
    }
}
