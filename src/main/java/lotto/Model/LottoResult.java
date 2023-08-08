package lotto.Model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private final Map<Ranking, Integer> result;
    private static final int DEFAULT = 0;

    public LottoResult() {
        this.result = new EnumMap<>(Ranking.class);
    }

    public void putResult(Ranking ranking) {
        result.put(ranking, result.getOrDefault(ranking, DEFAULT) + 1);
    }

    public Set<Ranking> keyset() {
        return result.keySet();
    }

    public Integer get(Ranking ranking) {
        return result.get(ranking);
    }

    public Map<Ranking, Integer> getResult() {
        return result;
    }
}
