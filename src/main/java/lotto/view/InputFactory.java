package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.BonusNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFactory {

    private final InputValidator inputValidator;

    public InputFactory() {
        this.inputValidator = new InputValidator();
    }

    public int readPurchaseAmount() {
        System.out.println(OutputMessage.GUIDE_PURCHASE);
        String userInput = Console.readLine();
        inputValidator.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public Lotto readWinningNumber() {
        System.out.println(OutputMessage.WINNING_NUMBER);
        String userInput = Console.readLine();
        inputValidator.validateWinningNumbers(userInput);
        List<Integer> winningNumber = Stream.of(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(winningNumber);
    }

    public BonusNumber readBonusNumber() {
        System.out.println(OutputMessage.BONUS_NUMBER);
        String userInput = Console.readLine();
        inputValidator.validateBonusNumber(userInput);
        return new BonusNumber(Integer.parseInt(userInput));
    }
}
