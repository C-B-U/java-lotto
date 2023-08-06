package lotto.producer.repository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ProducerRepository {

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Integer> createLottoNumber(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottos.add(new Lotto(lottoNumbers));
        return lottoNumbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
