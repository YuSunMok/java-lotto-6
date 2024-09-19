package lotto.controller;

import lotto.config.LottoConfig;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoConfig config) {
        inputView = config.getInputView();
        outputView = config.getOutputView();
    }

    public void run() {

    }
}
