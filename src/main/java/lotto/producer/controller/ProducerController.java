package lotto.producer.controller;

import lotto.producer.service.ProducerService;

public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(){
        this.producerService = new ProducerService();
    }

    public void getLottoNumber(int lottoAmount){
        producerService.getLottoNumbers(lottoAmount);
    }


}
