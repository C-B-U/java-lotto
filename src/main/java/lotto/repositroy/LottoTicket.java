package lotto.repositroy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Integer> ticket;

    public LottoTicket() {
        this.ticket = Randoms.pickUniqueNumbersInRange(LottoRangeNumber.MIN_LOTTO_NUM.getNum()
                , LottoRangeNumber.MAX_LOTTO_NUM.getNum(), LottoRangeNumber.NUM_OF_LOTTO_NUMS.getNum());
    }

    public List<Integer> getSorted() {
        return ticket.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> toList() {
        return ticket;
    }
}
