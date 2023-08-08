package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.BonusNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFactory {

    private final InputValidator inputValidator;
    private final OutputView outputView;

    public InputFactory() {
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
    }

    public int readPurchaseAmount() {
        outputView.printPurchaseMessage();
        String userInput = Console.readLine();
        inputValidator.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public Lotto readWinningNumber() {
        outputView.printWinningNumberMessage();
        String userInput = Console.readLine();
        inputValidator.validateWinningNumbers(userInput);
        List<Integer> winningNumber = Stream.of(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(winningNumber);
    }

    public BonusNumber readBonusNumber() {
        outputView.printBonusNumberMessage();
        String userInput = Console.readLine();
        inputValidator.validateBonusNumber(userInput);
        return new BonusNumber(Integer.parseInt(userInput));
    }
}
