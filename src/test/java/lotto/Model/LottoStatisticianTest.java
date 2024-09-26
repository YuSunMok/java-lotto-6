package lotto.Model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


class LottoStatisticianTest {

    private final LottoStatistician lottoStatistician = new LottoStatistician();

    @Test
    @DisplayName("(1등)주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic_first() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        Integer firstPlaceCount = lottoResultMap.get(Rank.FIRST_PLACE);

        // then
        Assertions.assertThat(firstPlaceCount).isEqualTo(1);
    }

    @Test
    @DisplayName("(2등)주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic_second() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 7));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        Integer firstPlaceCount = lottoResultMap.get(Rank.SECOND_PLACE);

        // then
        Assertions.assertThat(firstPlaceCount).isEqualTo(1);
    }


    @Test
    @DisplayName("(3등)주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic_third() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 31));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        Integer firstPlaceCount = lottoResultMap.get(Rank.THIRD_PLACE);

        // then
        Assertions.assertThat(firstPlaceCount).isEqualTo(2);
    }

    @Test
    @DisplayName("(4등)주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic_fourth() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 3, 4, 32, 33));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        Integer firstPlaceCount = lottoResultMap.get(Rank.FOURTH_PLACE);

        // then
        Assertions.assertThat(firstPlaceCount).isEqualTo(3);
    }

    @Test
    @DisplayName("(5등)주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic_fifth() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 3, 31, 32, 33));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        Integer result = lottoResultMap.get(Rank.FIFTH_PLACE);

        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("(등수 없음)주어진 로또 번호들의 통계치를 낼 수 있다.")
    public void statistic() {
        // given
        Lottos lottos = createLottos();
        Lotto winnngLotto = Lotto.of(List.of(1, 2, 31, 42, 44, 45));
        int bonusNumber = 7;

        // when
        LottoResult lottoResult = lottoStatistician.statistic(lottos, winnngLotto, bonusNumber);
        Map<Rank, Integer> lottoResultMap = lottoResult.getLottoResultMap();
        Integer firstPlaceCount = lottoResultMap.get(Rank.FIFTH_PLACE);
        Integer secondPlaceCount = lottoResultMap.get(Rank.SECOND_PLACE);
        Integer thirdPlaceCount = lottoResultMap.get(Rank.THIRD_PLACE);
        Integer fourthPlaceCount = lottoResultMap.get(Rank.FOURTH_PLACE);
        Integer fifthPlaceCount = lottoResultMap.get(Rank.FIFTH_PLACE);

        // then
        Assertions.assertThat(firstPlaceCount).isEqualTo(0);
        Assertions.assertThat(secondPlaceCount).isEqualTo(0);
        Assertions.assertThat(thirdPlaceCount).isEqualTo(0);
        Assertions.assertThat(fourthPlaceCount).isEqualTo(0);
        Assertions.assertThat(fifthPlaceCount).isEqualTo(0);
    }

    private static Lottos createLottos() {
        Lotto lotto1 = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.of(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = Lotto.of(List.of(1, 2, 3, 4, 9, 8));
        Lotto lotto4 = Lotto.of(List.of(1, 2, 3, 10, 9, 8));
        Lotto lotto5 = Lotto.of(List.of(1, 2, 11, 10, 9, 8));
        Lotto lotto6 = Lotto.of(List.of(7, 8, 9, 10, 11, 12));

        return Lottos.of(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
    }
}