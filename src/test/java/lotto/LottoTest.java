package lotto;

import lotto.Model.Lotto;
import lotto.Model.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
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

    @Test
    @DisplayName("로또 번호 리스트를 출력한다.")
    void toString_() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        // when
        String result = lotto.toString();

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("3개가 동일한 로또 번호일 경우 5등을 반환한다.")
    public void compareAt_FIFTH_PLACE() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(1, 2, 3, 7, 8, 9));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).contains(Rank.FIFTH_PLACE);
    }

    @Test
    @DisplayName("4개가 동일한 로또 번호일 경우 4등을 반환한다.")
    public void compareAt_FOURTH_PLACE() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(1, 2, 3, 4, 8, 9));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).contains(Rank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("5개가 동일한 로또 번호일 경우 3등을 반환한다.")
    public void compareAt_THIRD_PLACE() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(1, 2, 3, 4, 5, 9));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).contains(Rank.THIRD_PLACE);
    }

    @Test
    @DisplayName("5개와 보너스 번호 동일한 로또 번호일 경우 2등을 반환한다.")
    public void compareAt_SECOND_PLACE() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(1, 2, 3, 4, 5, 9));
        int bonusNumber = 6;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).contains(Rank.SECOND_PLACE);
    }

    @Test
    @DisplayName("6개가 동일한 로또 번호일 경우 1등을 반환한다.")
    public void compareAt_FIRST_PLACE() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).contains(Rank.FIRST_PLACE);
    }

    @Test
    @DisplayName("동일한 로또 번호가 없을 경우 빈 값을 반환한다.")
    public void compareAt_OptionalEmpty() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).isEmpty();
    }

    @Test
    @DisplayName("1개가 동일한 로또 번호일 경우 빈 값을 반환한다.")
    public void compareAt_OnePare() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).isEmpty();
    }

    @Test
    @DisplayName("2개가 동일한 로또 번호일 경우 빈 값을 반환한다.")
    public void compareAt_TwoPare() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto comparelotto = Lotto.of(List.of(7, 8, 9, 10, 11, 12));
        int bonusNumber = 10;

        // when
        Optional<Rank> optionalRank = lotto.compareAt(comparelotto, bonusNumber);

        // then
        Assertions.assertThat(optionalRank).isEmpty();
    }


}