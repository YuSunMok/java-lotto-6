package lotto.Model;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoException;
import lotto.exception.LottoGameException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DELIMITER = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Optional<Rank> compareAt(Lotto lotto, int bonusNumber) {
        int count = getCountFrom(lotto);
        if (count == 0) {
            return Optional.empty();
        }

        boolean isBonusContain = isBonusNumberContainLottoWinning(bonusNumber);

        return Optional.ofNullable(Rank.getRank(count, isBonusContain));
    }

    @Override
    public String toString() {
        return "[" + getLottoNumbers() + "]";
    }

    private int getCountFrom(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contain)
                .count();
    }

    private boolean contain(Integer number) {
        return numbers.contains(number);
    }

    private boolean isBonusNumberContainLottoWinning(int bonusNumber) {
        return contain(bonusNumber);
    }

    private String getLottoNumbers() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER));
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> randomNumberSet = new HashSet<>(numbers);
        if (LottoGameConfig.LOTTO_SIZE != randomNumberSet.size()) {
            throw new LottoGameException(LottoException.DUPLICATED_LOTTO);
        }
    }

}
