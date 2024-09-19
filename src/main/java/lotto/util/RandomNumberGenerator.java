package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;

import java.util.List;

public class RandomNumberGenerator {

    private final static int startNumber = LottoConfig.RANDOM_START_NUMBER;
    private final static int endNumber = LottoConfig.RANDOM_END_NUMBER;
    private final static int lottoCount = LottoConfig.LOTTO_NUMBER_COUNT;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, lottoCount);
    }

}
