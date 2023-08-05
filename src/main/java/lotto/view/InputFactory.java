package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputFactory {

    public int readPurchaseAmount() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
