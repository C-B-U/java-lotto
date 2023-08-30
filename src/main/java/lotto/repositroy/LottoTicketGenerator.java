package lotto.repositroy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGenerator {
    private final List<LottoTicket> tickets;

    public LottoTicketGenerator() {
        tickets = new ArrayList<>();
    }

    public void generateTicket(int ticketNum) {
        for (int i = 0; i < ticketNum; i++) {
            tickets.add(new LottoTicket());
        }
    }

    public List<List<Integer>> getSortedTickets() {
        return tickets.stream().map(LottoTicket::getSorted).collect(Collectors.toList());
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }
}
