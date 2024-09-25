package lotto.controller;

import lotto.Model.*;
import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStatistician lottoStatistician = new LottoStatistician();

    public LottoGameController(LottoGameConfig config) {
        inputView = config.getInputView();
        outputView = config.getOutputView();
    }

    public void run() {
        Money money = showCommentForMoney();
        Lottos lottos = outputView.showBuyLottoComments(money);

        Lotto winningLotto = showCommentForWinningLotto();

        int bonusNumber = showCommentForBonusNumber();

        statistic(lottos, winningLotto, bonusNumber);
    }

    private Money showCommentForMoney() {
        outputView.showCommentForMoney();
        return getInput(inputView::getMoneyFromUser);
    }

    private int showCommentForBonusNumber() {
        outputView.showCommentForBonusNumber();
        return getInput(inputView::getBonusNumberFromUser);
    }

    private Lotto showCommentForWinningLotto() {
        outputView.showCommentForWinningLotto();
        return getInput(inputView::getWinningLottoFromUser);
    }

    private void statistic(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        try {
            LottoResult lottoResult = lottoStatistician.statistic(lottos, winningLotto, bonusNumber);
            outputView.showCommentForWinningStatistic(lottoResult, lottos);
        } catch (LottoGameException e) {
            outputView.showExceptionMessage(e);
        } catch (Exception e) {
            outputView.showSimpleMessage("프로그램이 잘못 되었습니다.");
        }
    }

    private <T> T getInput(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (LottoGameException e) {
            outputView.showExceptionMessage(e);
            return inputSupplier.get();
        }
    }

}
