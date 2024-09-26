package lotto.config;

import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoGameConfig {

    public static final String LOTTO_NUMBER_INPUT_DELIMITER = ",";

    public static int RANDOM_START_NUMBER = 1;
    public static int RANDOM_END_NUMBER = 45;

    public static int LOTTO_SIZE = 6;

    public static int FIRST_PLACE_AMOUNT = 2_000_000_000;
    public static int SECOND_PLACE_AMOUNT = 30_000_000;
    public static int THIRD_PLACE_AMOUNT = 1_500_000;
    public static int FOURTH_PLACE_AMOUNT = 50_000;
    public static int FIFTH_PLACE_AMOUNT = 5_000;

    public static int FIRST_PLACE_COMPARE_COUNT = 6;
    public static int SECOND_PLACE_COMPARE_COUNT = 5;
    public static int THIRD_PLACE_COMPARE_COUNT = 5;
    public static int FOURTH_PLACE_COMPARE_COUNT = 4;
    public static int FIFTH_PLACE_COMPARE_COUNT = 3;

    public static int PRICE_PER_LOTTO = 1_000;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameConfig(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

}
