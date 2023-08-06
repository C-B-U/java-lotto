package lotto.member.repository;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private final List<Integer> winLottoNumber = new ArrayList<>();
    private int bonusNumber;

    public void saveWinLottoNumber(Integer winNumber){
        winLottoNumber.add(winNumber);
    }

    public List<Integer> getWinLottoNumber() {
        return winLottoNumber;
    }

    public void saveBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
