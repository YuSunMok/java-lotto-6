package lotto.Model;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    @DisplayName("Lotto 리스트가 null 이라면 LottoGameException 예외를 발생시킨다.")
    void of_null() {
        assertThatThrownBy(() -> Lottos.of(null))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    @DisplayName("Lotto 리스트가 빈값 이라면 LottoGameException 예외를 발생시킨다.")
    void of_empty() {
        List<Lotto> lottos = List.of();

        assertThatThrownBy(() -> Lottos.of(lottos))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    void getLottos() {
        int lottoSize = 1;
        List<Lotto> givenLottoList = getLottoList(lottoSize);
        Lottos givenLottos = Lottos.of(givenLottoList);

        List<Lotto> lottos = givenLottos.getLottos();

        assertThat(lottos).isEqualTo(givenLottoList);
        assertThat(lottos).isNotSameAs(givenLottoList);
    }

    @Test
    void getPurchasePrice() {
        int lottoSize = 3;
        List<Lotto> givenLottoList = getLottoList(lottoSize);
        Lottos givenLottos = Lottos.of(givenLottoList);

        int result = givenLottos.getPurchasePrice();

        assertThat(result).isEqualTo(3000);
    }

    private static List<Lotto> getLottoList(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Lotto.of(List.of(1, 2, 3, 4, 5, 6)))
                .toList();
    }

}