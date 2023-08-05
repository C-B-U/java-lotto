package lotto.Model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class PlayerLottoes {

    private final List<Lotto> lottoes;

    public PlayerLottoes(int lotteryTicketsNumber) {
        this.lottoes = generateLottoes(lotteryTicketsNumber);
    }

    private List<Lotto> generateLottoes(int lotteryTicketsNumber) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < lotteryTicketsNumber; i++) {
            RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
            lottoes.add(lottoGenerator.getRandomNumber());
        }
        return lottoes;
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }
}
