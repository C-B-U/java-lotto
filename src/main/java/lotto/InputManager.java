package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    private static final String COMMA_SPLITTER = ",";
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
        inputValidator.validateIsListWithComma(input);
        return convertToList(input);
    }

    private List<Integer> convertToList(final String input) {
        return Arrays.stream(input.split(COMMA_SPLITTER))
                .map(Integer::valueOf)
                .peek(inputValidator::validateLottoNumber)
                .collect(Collectors.toList());
    }

    public Integer bonusNumberInput() {
        final String input = Console.readLine();
        inputValidator.validateIsNumeric(input);
        final Integer bonusNumber = Integer.valueOf(input);
        inputValidator.validateLottoNumber(bonusNumber);
        return bonusNumber;
    }
}
