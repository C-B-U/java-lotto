package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final Integer ZERO = 0;
    private static final Integer MONEY_UNIT = 1000;
    private static final Double PERCENTAGE = 100.0;
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

    public Integer savePublishNumber(final Integer buyAmount) {
        final Integer publishNumber = divideByMoneyUnit(buyAmount);
        lottoRepository.savePublishNumber(publishNumber);
        return publishNumber;
    }

    private Integer divideByMoneyUnit(final Integer dividend) {
        return dividend / MONEY_UNIT;
    }

    public List<Lotto> publishLotto() {
        final Integer publishNumber = lottoRepository.findPublishNumber();
        final List<Lotto> lottoList = createLottoList(publishNumber);
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

    public ResultMap checkWinningNumber() {
        final List<Lotto> lottoList = lottoRepository.findAllLotto();
        final WinningNumber winningNumber = lottoRepository.findWinningNumber();
        final ResultMap resultMap = winningNumber.compareWithLottoList(lottoList);
        lottoRepository.saveRewardAmount(resultMap.getRewardAmount());
        return resultMap;
    }

    public Double checkEarningRate() {
        final long earnedAmount = lottoRepository.findRewardAmount();
        final int investmentAmount = getInvestment();
        return getEarningRate(earnedAmount, investmentAmount);
    }

    private double getEarningRate(final long earnedAmount, final int investmentAmount) {
        return ((double)earnedAmount / (double)investmentAmount) * PERCENTAGE;
    }

    private int getInvestment() {
        return lottoRepository.findPublishNumber() * MONEY_UNIT;
    }
}
