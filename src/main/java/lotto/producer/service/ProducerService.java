package lotto.producer.service;

import lotto.producer.repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerService(){
        this.producerRepository = new ProducerRepository();
    }

    public void getLottoNumbers(int lottoAmount){
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for (int i = 0; i < lottoAmount; i++){
            List<Integer> lottoNumber = producerRepository.createLottoNumber();
            System.out.println(resultLottoNumber(lottoNumber));
        }
    }

    public String resultLottoNumber(List<Integer> lottoNumber){
        StringBuilder lottoResult = new StringBuilder();
        lottoResult.append("[");
        for (int i = 0; i < lottoNumber.size()-1; i++){
            lottoResult.append(lottoNumber.get(i)).append(", ");
        }
        lottoResult.append(lottoNumber.get(lottoNumber.size()-1));
        lottoResult.append("]");
        return lottoResult.toString();
    }
    
}
