package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFactory {

    public int readPurchaseAmount() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }

    public Lotto readWinningNumber() {
        System.out.println(OutputMessage.WINNING_NUMBER);
        String userInput = Console.readLine();
        List<Integer> winningNumber = Stream.of(userInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(winningNumber);
    }
}
