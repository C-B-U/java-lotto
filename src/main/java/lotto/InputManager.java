package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public Integer buyAmountInput() {
        final String input = Console.readLine();
        return Integer.valueOf(input);
    }
}
