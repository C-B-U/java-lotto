package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> winningNumberInput() {
        final String input = Console.readLine();
        final List<Integer> winningNumber = convertToList(input);
        return winningNumber;
    }

    private List<Integer> convertToList(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public Integer bonusNumberInput() {
        final String input = Console.readLine();
        inputValidator.validateIsNumeric(input);

        final Integer inputNumber = Integer.valueOf(input);
        return inputNumber;
    }
}
