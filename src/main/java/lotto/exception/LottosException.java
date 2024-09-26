package lotto.exception;

public enum LottosException implements CustomException {

    LOTTO_TICKETS_REQUIERD("한 장 이상의 로또가 필요합니다."),
    INVALID_LOTTOS("유효하지 않은 로또들입니다."),
    ;

    private final String message;

    LottosException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
