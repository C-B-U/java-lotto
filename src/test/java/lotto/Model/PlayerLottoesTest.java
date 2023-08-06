package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerLottoesTest {

    @DisplayName("티켓 개수를 입력하면 갯수에 맞는 로또 번호 리스트가 생성된다.")
    @Test
    void createPlayerLottoes() {
        int ticketNumber = 8;
        PlayerLottoes playerLottoes = new PlayerLottoes(ticketNumber);
        assertThat(playerLottoes.size()).isEqualTo(ticketNumber);
    }
}
