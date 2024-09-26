package lotto.Model;

import lotto.config.LottoGameConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("(1등) 등수마다 총액을 반환할 수 있다.")
    void getTotalAmount_first() {
        int givenCount = 1;

        int result = Rank.FIRST_PLACE.getTotalAmount(givenCount);

        assertThat(result).isEqualTo(LottoGameConfig.FIRST_PLACE_AMOUNT);
    }

    @Test
    @DisplayName("(2등) 등수마다 총액을 반환할 수 있다.")
    void getTotalAmount_second() {
        int givenCount = 1;

        int result = Rank.SECOND_PLACE.getTotalAmount(givenCount);

        assertThat(result).isEqualTo(LottoGameConfig.SECOND_PLACE_AMOUNT);
    }

    @Test
    @DisplayName("(3등) 등수마다 총액을 반환할 수 있다.")
    void getTotalAmount_third() {
        int givenCount = 1;

        int result = Rank.THIRD_PLACE.getTotalAmount(givenCount);

        assertThat(result).isEqualTo(LottoGameConfig.THIRD_PLACE_AMOUNT);
    }

    @Test
    @DisplayName("(4등) 등수마다 총액을 반환할 수 있다.")
    void getTotalAmount_forth() {
        int givenCount = 1;

        int result = Rank.FOURTH_PLACE.getTotalAmount(givenCount);

        assertThat(result).isEqualTo(LottoGameConfig.FOURTH_PLACE_AMOUNT);
    }
    
    @Test
    @DisplayName("(5등) 등수마다 총액을 반환할 수 있다.")
    void getTotalAmount_fifth() {
        int givenCount = 1;

        int result = Rank.FIFTH_PLACE.getTotalAmount(givenCount);

        assertThat(result).isEqualTo(LottoGameConfig.FIFTH_PLACE_AMOUNT);
    }

    @Test
    @DisplayName("(1등) 조건에 알맞은 Rank를 반환한다.")
    void getRank_first() {
        int givenCount = 6;
        boolean bonus = false;

        Rank rank = Rank.getRank(givenCount, bonus);

        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    @DisplayName("(2등) 조건에 알맞은 Rank를 반환한다.")
    void getRank_second() {
        int givenCount = 5;
        boolean bonus = true;

        Rank rank = Rank.getRank(givenCount, bonus);

        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    @DisplayName("(3등) 조건에 알맞은 Rank를 반환한다.")
    void getRank_third() {
        int givenCount = 5;
        boolean bonus = false;

        Rank rank = Rank.getRank(givenCount, bonus);

        assertThat(rank).isEqualTo(Rank.THIRD_PLACE);
    }

    @Test
    @DisplayName("(4등) 조건에 알맞은 Rank를 반환한다.")
    void getRank_forth() {
        int givenCount = 4;
        boolean bonus = false;

        Rank rank = Rank.getRank(givenCount, bonus);

        assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("(5등) 조건에 알맞은 Rank를 반환한다.")
    void getRank_fifth() {
        int givenCount = 3;
        boolean bonus = false;

        Rank rank = Rank.getRank(givenCount, bonus);

        assertThat(rank).isEqualTo(Rank.FIFTH_PLACE);
    }

    @Test
    @DisplayName("조건에 알맞은 Rank가 없다면 null을 반환한다.")
    void getRank() {
        int givenCount = 1;
        boolean bonus = false;

        Rank rank = Rank.getRank(givenCount, bonus);

        assertThat(rank).isNull();
    }

}