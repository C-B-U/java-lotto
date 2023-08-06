package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return Randoms.pickUniqueNumbersInRange(
                Number.MIN_RANGE.toValue(),
                Number.MAX_RANGE.toValue(),
                Number.NUMBER_NUM.toValue());
    }

    public Integer getPublishNum(final Integer buyAmount) {
        return divideByThousand(buyAmount);
    }

    private Integer divideByThousand(final Integer dividend) {
        return dividend / Number.THOUSAND.toValue();
    }

    public List<LottoTicket> publishLottoTickets(final Integer publishNum) {
        final List<LottoTicket> lottoTickets = createLottoTickets(publishNum);
        lottoRepository.saveLottoTicket(lottoTickets);
        return lottoTickets;
    }

    private List<LottoTicket> createLottoTickets(final Integer publishNum) {
        return IntStream.range(Number.ZERO.toValue(), publishNum)
                .mapToObj(i -> createRandomNumbers())
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public WinningNumber saveWinningNumber(
            final List<Integer> winningNumberInput,
            final Integer bonusNumberInput) {

        final WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumberInput);
        lottoRepository.saveWinningNumber(winningNumber);
        return winningNumber;
    }
}
