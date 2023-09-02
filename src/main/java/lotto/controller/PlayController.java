package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.repositroy.LottoTicket;
import lotto.service.LottoTicketService;

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
        List<LottoTicket> tickets = ticketService.createLottoTickets(money);
        answerController.playLotto(tickets, money);
    }

    private int inputMoney() {
        System.out.println(InputGuide.INPUT_MONEY.getContent());
        return inputProcessor.changeToInt(Console.readLine());
    }
}
