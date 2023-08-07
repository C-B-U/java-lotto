package lotto;

import java.util.List;

public class LottoRepository {
    private List<Lotto> lotto;
    private WinningNumber winningNumber;
    private Integer publishNumber;
    private Long rewardAmount;

    public void savePublishNumber(final Integer publishNumber) {
        this.publishNumber = publishNumber;
    }

    public Integer findPublishNumber() {
        return this.publishNumber;
    }

    public void saveAllLotto(final List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public void saveWinningNumber(final WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Lotto> findAllLotto() {
        return this.lotto;
    }

    public WinningNumber findWinningNumber() {
        return this.winningNumber;
    }

    public void saveRewardAmount(final Long rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public Long findRewardAmount() {
        return this.rewardAmount;
    }
}
