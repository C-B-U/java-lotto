package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.WinningGrade.DEFAULT;

public class LottoCompare {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    Map<WinningGrade, Integer> winGames = new EnumMap<>(WinningGrade.class);

    public LottoCompare(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        resetWinGames();
        checkLottoTicket();
    }

    private void resetWinGames() {
        Arrays.stream(WinningGrade.values())
                .filter(winningGrade -> winningGrade != DEFAULT)
                .forEach(value -> winGames.put(value, 0));
    }

    private void checkLottoTicket() {
        lottos.forEach(lotto -> checkLotto(lotto));
    }

    private void checkLotto(Lotto lotto) {
        int correctNumberCount = getCorrectNumberCount(lotto);
        boolean hasBonusNumber = hasBonusNumber(lotto);
        WinningGrade winningGrade = WinningGrade.findGrade(correctNumberCount, hasBonusNumber);
        addWinGame(winningGrade);
    }

    private int getCorrectNumberCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

    private void addWinGame(WinningGrade winningGrade) {
        if (winningGrade != DEFAULT) {
            winGames.put(winningGrade, winGames.get(winningGrade) + 1);
        }
    }

    public Map<WinningGrade, Integer> getWinGames() {
        return this.winGames;
    }

    public long getTotalAmount() {
        return winGames.entrySet().stream()
                .map(entry -> (long) entry.getKey().getWinningAmount() * entry.getValue())
                .reduce((sumCashPrize1, sumCashPrize2) -> sumCashPrize1 + sumCashPrize2)
                .get();
    }
}