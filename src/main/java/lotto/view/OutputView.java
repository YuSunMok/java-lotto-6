package lotto.view;

import lotto.Model.Lotto;
import lotto.Model.Lottos;
import lotto.Model.Money;

import java.util.List;

public class OutputView {

    public void showCommentForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public Lottos showBuyLottoComments(Money money) {
        int count = showCommentForAvailableLottoCount(money);
        List<Lotto> lottos = showCommentsForByiedLottos(count);

        return Lottos.of(lottos);
    }

    private static int showCommentForAvailableLottoCount(Money money) {
        int count = money.getAvailableLottoCount();
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");

        return count;
    }

    private static List<Lotto> showCommentsForByiedLottos(int count) {
        List<Lotto> lottos = Lottos.createLottos(count);
        lottos.forEach(System.out::println);

        return lottos;
    }
}
