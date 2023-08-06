package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private static final Integer ONE = 1;
    private static final Integer BONUS_AVAILABLE = 5;
    private final Lotto winningNumbers;
    private final Integer bonusNumber;

    public WinningNumber(final List<Integer> winningNumbers, final Integer bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public ResultMap compareWithLottoList(final List<Lotto> lottoList) {
        final List<Integer> numbers = this.winningNumbers.getNumbers();
        numbers.add(bonusNumber);

        final List<RewardMoney> resultList = lottoList.stream()
                .map(Lotto::getNumbers)
                .map(ArrayList::new)
                .peek(lotto -> lotto.retainAll(numbers))
                .map(this::getResult)
                .collect(Collectors.toList());

        return new ResultMap(resultList);
    }

    private RewardMoney getResult(final List<Integer> lotto) {
        final boolean isBonusMatch = lotto.contains(bonusNumber);
        final int matchNum = getMatchNum(isBonusMatch, lotto.size());
        return getResultWithMatchNum(matchNum, isBonusMatch);
    }

    private RewardMoney getResultWithMatchNum(final int matchNum, final boolean isBonusMatch) {
        final RewardMoneyMap rewardMoneyMap = RewardMoneyMap.getInstance();
        if (matchNum != BONUS_AVAILABLE) {
            return rewardMoneyMap.getRewardMoney(matchNum, false);
        }
        return rewardMoneyMap.getRewardMoney(matchNum, isBonusMatch);
    }

    private int getMatchNum(final boolean isBonusMatch, final Integer size) {
        if (isBonusMatch) {
            return size - ONE;
        }
        return size;
    }
}
