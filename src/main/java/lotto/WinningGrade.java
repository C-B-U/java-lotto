package lotto;

import java.util.Arrays;

public enum WinningGrade {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    DEFAULT(0, 0, false);

    private static final int SECOND_OR_THIRD_WINNING_NUMBER_COUNT = 5;
    private final int winningAmount;
    private final int winningNumberCount;
    private final boolean hasBonusNumber;

    WinningGrade(int winningNumberCount, int winningAmount, boolean hasBonusNumber) {
        this.winningNumberCount = winningNumberCount;
        this.winningAmount = winningAmount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static WinningGrade findGrade(int winningNumberCount, boolean hasBonusNumber) {
        if (winningNumberCount == SECOND_OR_THIRD_WINNING_NUMBER_COUNT) { // 일치 개수가 5개면 보너스 번호 일치 여부 판단해야 함!!
            return findSecondOrThird(winningNumberCount, hasBonusNumber);
        }
        return findOthers(winningNumberCount);
    }

    private static WinningGrade findSecondOrThird(int winningNumberCount, boolean hasBonusNumber) {
        return Arrays.stream(WinningGrade.values())
                .filter(value -> value.winningNumberCount == winningNumberCount)
                .filter(value -> value.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(DEFAULT);
    }

    private static WinningGrade findOthers(int winningNumberCount) {
        return Arrays.stream(WinningGrade.values())
                .filter(value -> value.winningNumberCount == winningNumberCount)
                .findAny()
                .orElse(DEFAULT);
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }
}