package lotto.view;

import lotto.Model.Lotto;
import lotto.Model.Money;
import lotto.util.InputUtil;

import java.util.List;

public class InputView {

    public Money getMoneyFromUser() {
        int money = InputUtil.readInt();
        return Money.of(money);
    }

    public Lotto getWinningLottoFromUser() {
        return Lotto.of(InputUtil.readIntegerList());
    }

    public int getBonusNumberFromUser() {
        return InputUtil.readInt();
    }

}
