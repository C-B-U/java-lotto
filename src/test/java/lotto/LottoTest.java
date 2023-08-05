package lotto;

import lotto.member.repository.MemberRepository;
import lotto.member.service.MemberService;
import lotto.producer.repository.Lotto;
import lotto.producer.repository.ProducerRepository;
import lotto.producer.service.ProducerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class LottoTest {

    ProducerRepository producerRepository = mock(ProducerRepository.class);

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 제대로 생성되어 출력되는지 확인한다.")
    @Test
    void saveLottoNumberInRepository(){
        //given
        given(producerRepository.createLottoNumber()).willReturn(List.of(1,2,3,4,5,6));
        ProducerService producerService = new ProducerService();

        //when
        String resultLottoNumber = producerService.resultLottoNumber(List.of(1,2,3,4,5,6));

        //then
        assertThat(resultLottoNumber).isEqualTo("[1, 2, 3, 4, 5, 6]");

    }

    @DisplayName("로또 당첨번호가 타입이 변경된 후 저장소에 저장되어 반환하는지 확인한다.")
    @Test
    void saveWinLottoNumberInRepository(){
        //given
        MemberService memberService = new MemberService();
        MemberRepository memberRepository = new MemberRepository();
        List<Integer> winLottoNumber = memberService.getWinLottoNumber("1,2,3,4,5,6");

        //when
        for (Integer num : winLottoNumber){
            memberRepository.save(num);
        }

        //then
        assertThat(winLottoNumber).isEqualTo(memberRepository.getWinLottoNumber());

    }

    @DisplayName("보너스 번호가 타입이 변경된 후 저장소에 저장되어 반환되는지 확인한다.")
    @Test
    void saveBonusNumberInRepository(){
        //given
        MemberService memberService = new MemberService();
        MemberRepository memberRepository = new MemberRepository();
        int bonusNumber = memberService.getBonusNumber("7");

        //when
        memberRepository.saveBonusNumber(7);

        //then
        assertThat(bonusNumber).isEqualTo(memberRepository.getBonusNumber());
    }
}
