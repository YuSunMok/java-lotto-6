package lotto;

import lotto.config.LottoGameConfig;
import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoGameConfig config = new LottoGameConfig(
                new InputView(),
                new OutputView()
        );

        LottoGameController lottoGameController = new LottoGameController(config);
        lottoGameController.run();
    }
}
