package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardMoneyMap {
    private static final Integer DEFAULT_INDEX = 0;
    private static final Integer BONUS_INDEX = 1;
    private final Map<Integer, List<RewardMoney>> moneyMap = new HashMap<>();
    private static RewardMoneyMap rewardMoneyMap;

    public static RewardMoneyMap getInstance() {
        if (rewardMoneyMap == null) {
            rewardMoneyMap = new RewardMoneyMap();
        }
        return rewardMoneyMap;
    }

    private RewardMoneyMap() {
        initializeMoneyMap();
    }

    private void initializeMoneyMap() {
        moneyMap.put(0, List.of(RewardMoney.NONE));
        moneyMap.put(1, List.of(RewardMoney.NONE));
        moneyMap.put(2, List.of(RewardMoney.NONE));
        moneyMap.put(3, List.of(RewardMoney.THREE_MATCH));
        moneyMap.put(4, List.of(RewardMoney.FOUR_MATCH));
        moneyMap.put(5, List.of(RewardMoney.FIVE_MATCH, RewardMoney.MATCH_WITH_BONUS));
        moneyMap.put(6, List.of(RewardMoney.SIX_MATCH));
    }

    public RewardMoney getRewardMoney(final int matchNum, final boolean isBonusMatch) {
        final List<RewardMoney> rewardMoneyList = moneyMap.get(matchNum);
        if (matchNum != 5) {
            return rewardMoneyList.get(DEFAULT_INDEX);
        }
        return checkBonus(rewardMoneyList, isBonusMatch);
    }

    public Integer getMatchNum(final RewardMoney rewardMoney) {
        return moneyMap.entrySet().stream()
                .filter(entry -> entry.getValue().contains(rewardMoney))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CANNOT_FIND_RESULT.toString()));
    }

    private RewardMoney checkBonus(final List<RewardMoney> rewardMoneyList, final boolean isBonusMatch) {
        if (isBonusMatch) {
            return rewardMoneyList.get(BONUS_INDEX);
        }
        return rewardMoneyList.get(DEFAULT_INDEX);
    }
}
