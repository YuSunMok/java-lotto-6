package lotto.Model;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("Money생성시 0원을 넘어야 한다.")
    public void createMoney_moneyException() {
        int money = -100;

        assertThatThrownBy(() -> Money.of(money))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    @DisplayName("Money생성시 1000원 단위여야 한다.")
    public void createMoney_unitException() {
        int money = 100;

        assertThatThrownBy(() -> Money.of(money))
                .isInstanceOf(LottoGameException.class);
    }

    @Test
    @DisplayName("1,000원 단위만큼 구매가능한 로또 개수를 반환한다.")
    void getAvailableLottoCount() {
        Money money = createMoney(1000);

        int availableLottoCount = money.getAvailableLottoCount();

        assertThat(availableLottoCount).isEqualTo(1);
    }

    @Test
    @DisplayName("천원 단위만큼 로또를 개수를 생성한다.")
    void testGetAvailableLottoCount() {
        Money money = createMoney(8000);

        int count = money.getAvailableLottoCount();

        assertThat(count).isEqualTo(8);
    }

    private static Money createMoney(int money) {
        return Money.of(money);
    }

}