package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.AllLottoes;
import lotto.repositroy.LottoTicket;
import lotto.service.PlayLottoService;

import java.util.List;

public class LottoAnswerController {
    private final InputProcessor inputProcessor;
    private final PlayLottoService playLottoService;

    public LottoAnswerController() {
        this.inputProcessor = new InputProcessor();
        this.playLottoService = new PlayLottoService();
    }

    public void playLotto(List<LottoTicket> tickets, double paidMoney) {
        List<Integer> lottoAnswers = inputAnswerNumber();
        int bonusAnswer = intputBonusNumber();

        AllLottoes allLottoes = playLottoService.getAllLottoes(lottoAnswers, bonusAnswer);
        long totalPrizeMoney = playLottoService.playLotto(allLottoes, tickets);

        playLottoService.printEarningRate(totalPrizeMoney / paidMoney);
    }

    private List<Integer> inputAnswerNumber() {
        System.out.println(InputGuide.INPUT_LOTTO_ANSWER.getContent());
        return inputProcessor.changeToIntegerList(Console.readLine());
    }

    private int intputBonusNumber() {
        System.out.println(InputGuide.INPUT_BONUS_ANSWER.getContent());
        return inputProcessor.changeToInt(Console.readLine());
    }

}
