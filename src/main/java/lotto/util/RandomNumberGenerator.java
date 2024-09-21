package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoGameConfig;

import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {

    private final static int startNumber = LottoGameConfig.RANDOM_START_NUMBER;
    private final static int endNumber = LottoGameConfig.RANDOM_END_NUMBER;
    private final static int lottoCount = LottoGameConfig.LOTTO_NUMBER_COUNT;

    public static List<Integer> generateSorted() {
        List<Integer> randomNumbers = getRandomNumbers();
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
