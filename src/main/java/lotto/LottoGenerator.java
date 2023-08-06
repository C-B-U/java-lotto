package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final OutputView outputView = new OutputView();
    private static final int FIRST_COUNT = 1;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final int LOTTO_SIZE = 6;

    List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> generateLottoNumbers(int purchaseQuantity) {
        for (int count = FIRST_COUNT; count <= purchaseQuantity; count++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, LOTTO_SIZE);
            lottos.add(new Lotto(lottoNumber));
        }
        outputView.printLotto(lottos);
        return lottos;
    }
}
