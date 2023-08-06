package lotto.producer.controller;

import lotto.producer.repository.Lotto;
import lotto.producer.service.ProducerService;

import java.util.List;

public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(){
        this.producerService = new ProducerService();
    }

    public List<Lotto> getLottoNumbers(int lottoAmount){
        return producerService.getLottoNumbers(lottoAmount);
    }


}
