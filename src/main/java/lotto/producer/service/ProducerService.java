package lotto.producer.service;

import lotto.producer.repository.Lotto;
import lotto.producer.repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerService(){
        this.producerRepository = new ProducerRepository();
    }

    public List<Lotto> getLottoNumbers(int lottoAmount){
        System.out.print(OutputMessage.ENTER.getMessage());
        System.out.println(lottoAmount + OutputMessage.PURCHASED.getMessage());
        for (int i = 0; i < lottoAmount; i++){
            List<Integer> lottoNumber = producerRepository.createLottoNumber();
            System.out.println(resultLottoNumber(lottoNumber));
        }
        System.out.print(OutputMessage.ENTER.getMessage());
        return producerRepository.getLottos();
    }

    public String resultLottoNumber(List<Integer> lottoNumber){
        StringBuilder lottoResult = new StringBuilder();
        lottoResult.append(OutputMessage.FIRST_BRACKET.getMessage());
        for (int i = 0; i < lottoNumber.size()-1; i++){
            lottoResult.append(lottoNumber.get(i))
                    .append(OutputMessage.COMMA.getMessage())
                    .append(OutputMessage.BLANK.getMessage());
        }
        lottoResult.append(lottoNumber.get(lottoNumber.size()-1));
        lottoResult.append(OutputMessage.LAST_BRACKET.getMessage());
        return lottoResult.toString();
    }
    
}
