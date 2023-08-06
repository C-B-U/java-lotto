package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private final InputValidator inputValidator;

    public InputManager(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public Integer buyAmountInput() {
        final String input = Console.readLine();
        inputValidator.validateIsNumeric(input);

        final Integer inputNumber = Integer.valueOf(input);
        inputValidator.validateMultiplyOfThousand(inputNumber);

        return inputNumber;
    }
}
