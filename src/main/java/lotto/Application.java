package lotto;

import lotto.lottoManager.controller.LottoManagerController;

public class Application {
    public static void main(String[] args) {
        try{
            LottoManagerController lottoManagerController = new LottoManagerController();
            lottoManagerController.startLotto();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
