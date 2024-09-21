package lotto.view;

import lotto.Model.Money;

public class OutputView {

    public void showCommentForMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showBuyLottoComments(Money money) {
        int count = money.getAvailableLottoCount();
        System.out.println(count + "개를 구매했습니다.");
    }
}
