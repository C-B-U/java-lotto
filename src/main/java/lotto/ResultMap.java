package lotto;

import java.util.*;

public class ResultMap {
    private static final Integer NONE = 0;
    private static final Integer ONE = 1;
    private final Map<RewardMoney, Integer> resultMap = new EnumMap<>(RewardMoney.class);

    public ResultMap(final List<RewardMoney> resultList) {
        initializeResultMap();
        putData(resultList);
    }

    private void initializeResultMap() {
        Arrays.stream(RewardMoney.values()).forEach(rewardMoney -> {
            if (!rewardMoney.equals(RewardMoney.MATCH_WITH_BONUS)) {
                this.resultMap.put(rewardMoney, NONE);
                return;
            }
            this.resultMap.put(rewardMoney, NONE);
        });
    }

    private void putData(final List<RewardMoney> rewardMoneyList) {
        rewardMoneyList.forEach(result -> this.resultMap.put(result, this.resultMap.get(result) + ONE));
    }

    public Map<RewardMoney, Integer> getResultMap() {
        return this.resultMap;
    }

    public Long getRewardAmount() {
        return this.resultMap.keySet().stream()
                .map(rewardMoney -> rewardMoney.toValue() * resultMap.get(rewardMoney))
                .reduce(0L, Long::sum);
    }
}
