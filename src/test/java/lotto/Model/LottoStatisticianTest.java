package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticianTest {

    private final LottoStatistician lottoStatistician = new LottoStatistician();

    @Test
    @DisplayName("주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);

        // then

    }

    private static Lottos createLottos() {
        Lotto lotto1 = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.of(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = Lotto.of(List.of(13, 14, 15, 16, 17, 18));

        return Lottos.of(List.of(lotto1, lotto2, lotto3));
    }
}