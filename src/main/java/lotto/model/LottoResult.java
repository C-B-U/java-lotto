package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final Map<Ranking, Integer> result;

    public LottoResult() {
        this.result = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values())
                .forEach(ranking -> result.put(ranking, 0));
    }

    public void putResult(Ranking ranking) {
        result.put(ranking, result.get(ranking) + 1);
    }

    public Set<Ranking> keySet() {
        return result.keySet();
    }

    public Integer get(Ranking ranking) {
        return result.get(ranking);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(Ranking.values())
                .filter(ranking -> ranking != Ranking.NONE)
                .forEach(ranking -> {
                    appendMatchNumberMessage(ranking, stringBuilder);
                    appendBonusMessage(ranking, stringBuilder);
                    appendPrizeAmountMessage(ranking, stringBuilder);
                    appendWinningNumberMessage(ranking, stringBuilder);
                    stringBuilder.append(ResultMessage.NEW_LINE);
                });
        return stringBuilder.toString();
    }

    private void appendMatchNumberMessage(Ranking ranking, StringBuilder stringBuilder) {
        ResultMessage resultMessage = ResultMessage.MATCH_NUMBER_MESSAGE;
        int matchNumber = ranking.getMatchNumber();
        stringBuilder.append(String.format(resultMessage.toString(), matchNumber));
    }

    private void appendPrizeAmountMessage(Ranking ranking, StringBuilder stringBuilder) {
        ResultMessage resultMessage = ResultMessage.AMOUNT_MESSAGE;
        int prize = ranking.getPrize();
        stringBuilder.append(String.format(resultMessage.toString(), prize));
    }

    private void appendBonusMessage(Ranking ranking, StringBuilder stringBuilder) {
        if (ranking == Ranking.SECOND) {
            stringBuilder.append(ResultMessage.BONUS_MESSAGE);
        }
    }

    private void appendWinningNumberMessage(Ranking ranking, StringBuilder stringBuilder) {
        ResultMessage resultMessage = ResultMessage.WINNING_NUMBER_MESSAGE;
        int winningNumber = result.get(ranking);
        stringBuilder.append(String.format(resultMessage.toString(), winningNumber));
    }
}
