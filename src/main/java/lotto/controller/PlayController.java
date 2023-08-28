package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.InputProcessor;
import lotto.service.LottoTicketService;
import lotto.service.OutputGuide;

import java.util.List;

public class PlayController {
    private final LottoTicketService ticketService;
    private final InputProcessor inputProcessor;
    private final LottoAnswerController answerController;

    public PlayController() {
        this.ticketService = new LottoTicketService();
        this.inputProcessor = new InputProcessor();
        this.answerController = new LottoAnswerController();
    }


    public void start() {
        int money = inputMoney();
        List<List<Integer>> tickets = ticketService.createLottoTickets(money);
        answerController.playLotto(tickets);
    }

    private int inputMoney() {
        System.out.println(InputGuide.INPUT_MONEY.getContent());
        int money = inputProcessor.changeToInt(Console.readLine());

        return money;
    }


}
