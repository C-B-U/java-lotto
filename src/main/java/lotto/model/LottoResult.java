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

    public Map<Ranking, Integer> getResult() {
        return result;
    }
}
