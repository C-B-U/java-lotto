package lotto.lottoManager.controller;

import lotto.lottoManager.service.LottoManagerService;
import lotto.member.controller.MemberController;
import lotto.producer.controller.ProducerController;
import lotto.producer.repository.Lotto;

import java.util.List;

public class LottoManagerController {

    private final MemberController memberController;
    private final ProducerController producerController;
    private final LottoManagerService lottoManagerService;

    public LottoManagerController(){
        this.memberController = new MemberController();
        this.producerController = new ProducerController();
        this.lottoManagerService = new LottoManagerService();
    }

    public void startLotto(){
       int lottoPrice =  memberController.inputLottoPrice();
       List<Lotto> lottos = producerController.getLottoNumbers(lottoCount(lottoPrice));
       List<Integer> winNumber = memberController.inputWinLottoNumber();
       int bonusNumber = memberController.inputBonusNumber();
       lottoManagerService.getStatistics(lottos, winNumber,bonusNumber);
       lottoManagerService.getLottoRate(lottoPrice);
    }

    private int lottoCount(int lottoAmount){
        return lottoAmount / 1000;
    }
}
