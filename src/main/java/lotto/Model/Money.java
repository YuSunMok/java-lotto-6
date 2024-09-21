package lotto.Model;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.exception.MoneyException;

import java.util.Objects;

public class Money {

    private static final int UNIT = LottoGameConfig.PRICE_PER_LOTTO;

    private final int money;

    private Money(int money) {
        validateMoney(money);
        validateUnit(money);
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public int getAvailableLottoCount() {
        return money / UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    private void validateUnit(int money) {
        if (money % UNIT != 0) {
            throw new LottoGameException(MoneyException.INVALID_UNIT);
        }
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new LottoGameException(MoneyException.INVALID_MONEY);
        }
    }

}
