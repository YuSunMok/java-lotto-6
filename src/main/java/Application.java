import lotto.config.LottoConfig;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        LottoConfig config = new LottoConfig(
                new InputView(),
                new OutputView()
        );

        LottoController lottoController = new LottoController(config);
        lottoController.run();
    }
}
