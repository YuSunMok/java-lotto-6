package lotto.Model;

import lotto.config.LottoGameConfig;
import lotto.exception.LottoGameException;
import lotto.exception.LottosException;
import lotto.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        validateLottos(lottos);
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

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getPurchasePrice() {
        return lottos.size() * LottoGameConfig.PRICE_PER_LOTTO;
    }

    private static void validateLottos(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new LottoGameException(LottosException.LOTTO_TICKETS_REQUIERD);
        }
    }

    public boolean isInvalid() {
        return lottos == null || lottos.isEmpty();
    }

}
