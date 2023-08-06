package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(final LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void saveLotto() {
        final Lotto lotto = new Lotto(createRandomNumbers());
        lottoRepository.saveLotto(lotto);
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Integer getPublishNum(final Integer buyAmount) {
        return divideByThousand(buyAmount);
    }

    private Integer divideByThousand(final Integer dividend) {
        return dividend / 1000;
    }
}
