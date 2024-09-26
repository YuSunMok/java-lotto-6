package lotto.exception;

public enum LottoResultException implements CustomException {

    INVALID_LOTTO_RESULT("유효하지 않는 값입니다."),
    ;

    private final String message;

    LottoResultException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
