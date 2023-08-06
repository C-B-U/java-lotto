package lotto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultMap {
    private static final Integer NONE = 0;
    private static final Integer ONE = 1;
    private final Map<Result, Integer> resultMap = new LinkedHashMap<>();

    public ResultMap(final List<Result> resultList) {
        initializeResultMap();
        putData(resultList);
    }

    private void initializeResultMap() {
        Arrays.stream(RewardMoney.values()).forEach(rewardMoney -> {
            if (!rewardMoney.equals(RewardMoney.MATCH_WITH_BONUS)) {
                this.resultMap.put(new Result(rewardMoney, NONE, false), NONE);
                return;
            }
            this.resultMap.put(new Result(rewardMoney, NONE, true), NONE);
        });
    }

    private void putData(final List<Result> resultList) {
        resultList.forEach(result -> this.resultMap.put(result, this.resultMap.get(result) + ONE));
    }

    public Map<Result, Integer> getResultMap() {
        return this.resultMap;
    }

    public Long getRewardAmount() {
        return this.resultMap.keySet().stream()
                .map(result -> result.getRewardMoney().toValue() * resultMap.get(result))
                .reduce(0L, Long::sum);
    }
}
