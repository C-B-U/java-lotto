package lotto.repositroy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.LottoRangeNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    private final List<List<Integer>> tickets;

    public LottoTicketGenerator() {
        tickets = new ArrayList<>();
    }

    public void generateTicket(int ticketNum) {
        for (int i = 0; i < ticketNum; i++) {
            tickets.add(generateNumber());
        }
    }

    private List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoRangeNumber.MIN_LOTTO_NUM.getNum()
                , LottoRangeNumber.MAX_LOTTO_NUM.getNum(), LottoRangeNumber.NUM_OF_LOTTO_NUMS.getNum());
    }

    public List<List<Integer>> getSortedTickets() {
        return tickets;
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }
}
