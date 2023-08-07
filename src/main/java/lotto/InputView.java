package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    private final InputValidator inputValidator = new InputValidator();
    private List<Integer> winningNumbers;

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        inputValidator.validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER);
        winningNumbers = splitByComma(Console.readLine());
        inputValidator.validateWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        inputValidator.validateBonusNumber(winningNumbers, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    // 첫 단추를 잘못 끼워서 여기서 에러처리...
    private List<Integer> splitByComma(String numbers) {
        try {
            List<String> numberArray = Arrays.asList(numbers.split(COMMA));
            return numberArray.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 가능합니다.");
        }
    }
}
