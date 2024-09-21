package lotto.Model;

import lotto.config.LottoGameConfig;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGameConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "[" +
                numbers.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "]";
    }
}
