package lotto.exception;

public enum LottosException implements CustomException {

    INVALID_LOTTOS("한 장 이상의 로또가 필요합니다.")
    ;

    private final String message;

    LottosException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
