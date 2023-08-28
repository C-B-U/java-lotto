package lotto.service;

import lotto.ErrorMessage;
import lotto.repositroy.LottoTicketGenerator;

import java.util.Arrays;
import java.util.List;

public class LottoTicketService {
    private static final int ZERO = 0;
    private static final int MONEY_UNIT = 1000;
    private final LottoTicketGenerator ticketGenerator;

    public LottoTicketService() {
        this.ticketGenerator = new LottoTicketGenerator();
    }

    public List<List<Integer>> createLottoTickets(int money) {
        validate(money);
        ticketGenerator.generateTicket(getTicketNum(money));
        printTickets();

        return ticketGenerator.getTickets();
    }

    private void validate(int money) {
        if (money % MONEY_UNIT != ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OF_MONEY_UNIT.getMessage());
        }
    }

    private void printTickets() {
        ticketGenerator.getSortedTickets().forEach(t ->
                System.out.println(Arrays.toString(t.stream().sorted().toArray())));
    }
}
