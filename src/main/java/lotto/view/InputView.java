package lotto.view;

import lotto.Model.Money;
import lotto.util.InputUtil;

public class InputView {

    public Money getMoneyFromUser() {
        int money = InputUtil.readInt();
        return Money.of(money);
    }

}
