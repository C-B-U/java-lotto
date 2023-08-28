package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputProcessor {

    public int changeToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public List<Integer> changeToIntegerList(String s) {
        return Arrays.stream(s.split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
