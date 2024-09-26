package lotto.Model;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

    @Test
    @DisplayName("로또 결과 생성시 인자값이 null이라면 에러를 발생시킨다.")
    void of_null() {
        assertThatThrownBy(() -> LottoResult.of(null))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    @DisplayName("로또 결과에 등수를 반영할 수 있다.")
    void reflectAt() {
        Map<Rank, Integer> map = new HashMap<>();
        LottoResult givenLottoresult = LottoResult.of(map);

        LottoResult result = givenLottoresult.reflectAt(Rank.FIRST_PLACE);

        map.put(Rank.FIRST_PLACE, 1);
        LottoResult lottoResult = LottoResult.of(map);
        assertThat(result).isEqualTo(lottoResult);
    }

    @Test
    @DisplayName("등수만큼 출력 문구 리스트를 반환한다.")
    void getLottoResultForDisplay() {
        LottoResult lottoResult = LottoResult.of(new HashMap<>());

        List<String> lottoResultForDisplay = lottoResult.getLottoResultForDisplay();

        assertThat(lottoResultForDisplay).hasSize(5);
    }

    @Test
    @DisplayName("수익률을 반환한다.")
    void getRateOfReturn() {
        Lottos lottos = Lottos.of(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))));
        LottoResult lottoResult = LottoResult.of(new HashMap<>());

        double result = lottoResult.getRateOfReturn(lottos);

        assertThat(result).isEqualTo(0);
    }

}