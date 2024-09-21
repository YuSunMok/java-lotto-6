package lotto.Model;

import lotto.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static List<Lotto> createLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> Lotto.of(RandomNumberGenerator.generateSorted()))
                .toList();
    }
}
