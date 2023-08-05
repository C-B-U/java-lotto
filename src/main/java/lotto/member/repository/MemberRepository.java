package lotto.member.repository;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private final List<Integer> winLottoNumber = new ArrayList<>();

    public void save(Integer number){
        winLottoNumber.add(number);
    }

    public List<Integer> getWinLottoNumber() {
        return winLottoNumber;
    }
}
