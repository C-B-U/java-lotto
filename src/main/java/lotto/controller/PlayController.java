package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.service.LottoTicketService;
import lotto.service.OutputGuide;

public class PlayController {
    private final LottoTicketService lottoTicketService;

    public PlayController() {
        this.lottoTicketService = new LottoTicketService();
    }


    public void start() {
        int money = inputMoney();
        lottoTicketService.createLottoTickets(money);
    }

    private int inputMoney() {
        System.out.println(InputGuide.INPUT_MONEY.getContent());
        int money = changeToInt(Console.readLine());
        System.out.println(money + OutputGuide.NUMBER_OF_PURCHASE.getContent());

        return money;
    }

    private int changeToInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

}
