package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoGameConfig;
import lotto.exception.LottoException;
import lotto.exception.LottoGameException;
import lotto.exception.LottosException;

import java.util.*;

public class RandomNumberGenerator {

    private final static int startNumber = LottoGameConfig.RANDOM_START_NUMBER;
    private final static int endNumber = LottoGameConfig.RANDOM_END_NUMBER;
    private final static int lottoCount = LottoGameConfig.LOTTO_SIZE;

    public static List<Integer> generateSorted() {
        List<Integer> randomNumbers = new ArrayList<>(getRandomNumbers());
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private static List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                startNumber,
                endNumber,
                lottoCount
        );
    }

}
