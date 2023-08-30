package lotto.controller;

import lotto.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class InputProcessor {
    private static final String CRITERIA = ",";

    public int changeToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            ErrorMessage.NOT_NUMBER.print();
            throw new NoSuchElementException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public List<Integer> changeToIntegerList(String s) {
        return Arrays.stream(s.split(CRITERIA))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
