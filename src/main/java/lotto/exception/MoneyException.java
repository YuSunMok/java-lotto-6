package lotto.exception;

import lotto.config.LottoGameConfig;

public enum MoneyException implements CustomException {

    INVALID_MONEY("금액은 0원 이상이어야 합니다."),
    INVALID_UNIT("금액은 " + LottoGameConfig.PRICE_PER_LOTTO + "원 단위어야 합니다."),
    ;

    private final String message;

    MoneyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
