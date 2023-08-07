package lotto;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.ErrorMessage.*;

public class InputValidator {
    private static final String BLANK = " ";
    private static final int LOTTO_PRICE = 1000;
    private static final int IS_THOUSAND_WON_UNIT = 0;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int NUMBER_MINIMUM_RANGE = 1;
    private static final int NUMBER_MAXIMUM_RANGE = 45;

    public void validatePurchaseAmount(String purchaseAmount) {
        validatePurchaseAmountIsDigit(purchaseAmount);
        validateIsThousandWonUnit(purchaseAmount);
        validateHasBlank(purchaseAmount);
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateElementIsDigit(winningNumbers);
        validateDuplicatedLottoNumber(winningNumbers);
        validateSizeLottoNumber(winningNumbers);
        validateRangeLottoNumber(winningNumbers);
    }

    public void validateBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        validateBonusNumberIsDigit(bonusNumber);
        validateRangeBonusNumber(bonusNumber);
        validateDuplicatedWinningNumbersWithBonusNumber(winningNumbers, bonusNumber);
    }

    private void validateDuplicatedWinningNumbersWithBonusNumber(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_DUPLICATED_WITH_WINNING.getMessage());
        }
    }

    private void validateIsThousandWonUnit(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % LOTTO_PRICE != IS_THOUSAND_WON_UNIT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_THOUSAND_UNIT.getMessage());
        }
    }

    private void validateElementIsDigit(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(number -> Character.isDigit(number))
                .forEach(index -> {
                    throw new IllegalArgumentException(WINNING_IS_ONLY_NUMERIC.getMessage());
                });
    }

    private void validatePurchaseAmountIsDigit(String string) {
        IntStream.range(0, string.length())
                .filter(index -> !Character.isDigit(string.charAt(index)))
                .forEach(index -> { throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_ONLY_NUMERIC.getMessage());
        });
    }

    private void validateHasBlank(String purchaseAmount) {
        if (purchaseAmount.contains(BLANK)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_HAS_NOT_BLANK.getMessage());
        }
    }
    public void validateDuplicatedLottoNumber(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(LOTTO_HAS_DUPLICATED.getMessage());
        }
    }

    public void validateSizeLottoNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_HAS_SIX_NUMBER.getMessage());
        }
    }

    public void validateRangeLottoNumber(List<Integer> numbers) {
        if (!(numbers.stream().allMatch(number -> number >= NUMBER_MINIMUM_RANGE && number <= NUMBER_MAXIMUM_RANGE))) {
            throw new IllegalArgumentException(LOTTO_IS_1_MORE_OR_45_LESS.getMessage());
        }
    }

    private void validateBonusNumberIsDigit(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(BONUS_IS_ONLY_NUMERIC.getMessage());
        }
    }

    public void validateRangeBonusNumber(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) < NUMBER_MINIMUM_RANGE || Integer.parseInt(purchaseAmount) > NUMBER_MAXIMUM_RANGE) {
            throw new IllegalArgumentException(BONUS_IS_1_MORE_OR_45_LESS.getMessage());
        }
    }
}
