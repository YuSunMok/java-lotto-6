package lotto.exception;

public enum RankException implements CustomException {

    RANK_NOT_FOUND("존재하지 않는 등수입니다."),
    INVALID_RANK("유효하지 않는 등수입니다."),
    ;

    private final String message;

    RankException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
