package lotto.view;

import lotto.Model.*;
import lotto.exception.LottoGameException;

import java.util.List;

public class OutputView {

    private static final String ERROR = "[ERROR] ";

    public void showCommentForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Lottos showBuyLottoComments(Money money) {
        int count = showCommentForAvailableLottoCount(money);
        List<Lotto> lottos = showCommentsForByiedLottos(count);

        return Lottos.of(lottos);
    }

    private int showCommentForAvailableLottoCount(Money money) {
        int count = money.getAvailableLottoCount();
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        return count;
    }

    private List<Lotto> showCommentsForByiedLottos(int count) {
        List<Lotto> lottos = Lottos.createLottos(count);
        lottos.forEach(System.out::println);

        return lottos;
    }

    public void showCommentForWinningLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showCommentForBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showCommentForWinningStatistic(LottoResult lottoResult, Lottos lottos) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (String info : lottoResult.getLottoResultForDisplay()) {
            System.out.println(info);
        }

        System.out.println("총 수익률은 " + lottoResult.getRateOfReturn(lottos) + "%입니다.");
    }

    public void showExceptionMessage(LottoGameException e) {
        System.out.println(ERROR + e.getMessage());
    }

    public void showSimpleMessage(String message) {
        System.out.println(message);
    }
}
