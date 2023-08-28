package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputProcessor;
import lotto.dto.AllLottoes;
import lotto.service.PlayLottoService;

import java.util.List;

public class LottoAnswerController {
    private final InputProcessor inputProcessor;
    private final PlayLottoService playLottoService;

    public LottoAnswerController() {
        this.inputProcessor = new InputProcessor();
        this.playLottoService = new PlayLottoService();
    }

    public void playLotto(List<List<Integer>> tickets) {
        List<Integer> lottoAnswers = inputAnswerNumber();
        int bonusAnswer = intputBonusNumber();
        AllLottoes allLottoes = playLottoService.setAllLottoes(lottoAnswers, bonusAnswer);
        playLottoService.playLotto(allLottoes, tickets);
    }

    private List<Integer> inputAnswerNumber() {
        System.out.println(InputGuide.INPUT_LOTTO_ANSWER);
        return inputProcessor.changeToIntegerList(Console.readLine());
    }

    private int intputBonusNumber() {
        System.out.println(InputGuide.INPUT_BONUS_ANSWER);
        return inputProcessor.changeToInt(Console.readLine());
    }

}
