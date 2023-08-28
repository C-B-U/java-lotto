package lotto;

import lotto.service.MatchNum;

import java.util.*;

public class PrizeResult {
    private final Map<MatchNum, Integer> playResult = new EnumMap<>(MatchNum.class);
    private final Map<MatchNum, PrizeMoney> prizeMoneyMap = new EnumMap<>(MatchNum.class);

    public void initialize() {

        Iterator<PrizeMoney> prizeMoneyIterator = Arrays.stream(PrizeMoney.values()).iterator();
        for (MatchNum matchNum : MatchNum.values()) {
            prizeMoneyMap.put(matchNum, prizeMoneyIterator.next());
        }
    }

}
