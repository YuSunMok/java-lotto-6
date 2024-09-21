package lotto.controller;

import lotto.Model.Money;
import lotto.config.LottoGameConfig;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(LottoGameConfig config) {
        inputView = config.getInputView();
        outputView = config.getOutputView();
    }

    public void run() {
        outputView.showCommentForMoney();
        Money money = inputView.getMoneyFromUser();

        outputView.showBuyLottoComments(money);
    }
}
