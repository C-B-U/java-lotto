package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final Integer MONEY_UNIT = 1000;
    private static final Integer ZERO = 0;
    private final LottoRepository lottoRepository;

    public LottoService(final LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoNumberRange.MIN_RANGE.toValue(),
                LottoNumberRange.MAX_RANGE.toValue(),
                LottoNumberRange.NUMBER_NUM.toValue());
    }

    public Integer getPublishNum(final Integer buyAmount) {
        return divideByMoneyUnit(buyAmount);
    }

    private Integer divideByMoneyUnit(final Integer dividend) {
        return dividend / MONEY_UNIT;
    }

    public List<Lotto> publishLotto(final Integer publishNum) {
        final List<Lotto> lottoList = createLottoList(publishNum);
        lottoRepository.saveAllLotto(lottoList);
        return lottoList;
    }

    private List<Lotto> createLottoList(final Integer publishNum) {
        return IntStream.range(ZERO, publishNum)
                .mapToObj(i -> createRandomNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public void saveWinningNumber(
            final List<Integer> winningNumberInput,
            final Integer bonusNumberInput) {

        final WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumberInput);
        lottoRepository.saveWinningNumber(winningNumber);
    }
}
