package lotto.Model;

import java.util.Arrays;

import static lotto.config.LottoGameConfig.*;

public enum Rank implements RankInformation {


    FIRST_PLACE(FIRST_PLACE_COMPARE_COUNT, FIRST_PLACE_AMOUNT) {

        @Override
        public String getDisplayRankInfo(int count) {
            return getDisplayString(FIRST_PLACE.compareCount, FIRST_PLACE.amount, count);
        }

        @Override
        public boolean isSameCount(int count, boolean bonusContain) {
            return count == FIRST_PLACE.compareCount;
        }
    },
    SECOND_PLACE(SECOND_PLACE_COMPARE_COUNT, SECOND_PLACE_AMOUNT) {

        @Override
        public String getDisplayRankInfo(int count) {
            return getDisplayBonusString(SECOND_PLACE.compareCount, SECOND_PLACE.amount, count);
        }

        @Override
        public boolean isSameCount(int count, boolean bonusContain) {
            return count == SECOND_PLACE.compareCount && bonusContain;
        }
    },
    THIRD_PLACE(THIRD_PLACE_COMPARE_COUNT, THIRD_PLACE_AMOUNT) {

        @Override
        public String getDisplayRankInfo(int count) {
            return getDisplayString(THIRD_PLACE.compareCount, THIRD_PLACE.amount, count);
        }

        @Override
        public boolean isSameCount(int count, boolean bonusContain) {
            return count == THIRD_PLACE.compareCount && !bonusContain;
        }
    },
    FOURTH_PLACE(FOURTH_PLACE_COMPARE_COUNT, FOURTH_PLACE_AMOUNT) {

        @Override
        public String getDisplayRankInfo(int count) {
            return getDisplayString(FOURTH_PLACE.compareCount, FOURTH_PLACE.amount, count);
        }

        @Override
        public boolean isSameCount(int count, boolean bonusContain) {
            return count == FOURTH_PLACE.compareCount;
        }
    },
    FIFTH_PLACE(FIFTH_PLACE_COMPARE_COUNT, FIFTH_PLACE_AMOUNT) {

        @Override
        public String getDisplayRankInfo(int count) {
            return getDisplayString(FIFTH_PLACE.compareCount, FIFTH_PLACE.amount, count);
        }

        @Override
        public boolean isSameCount(int count, boolean bonusContain) {
            return count == FIFTH_PLACE.compareCount;
        }
    },
    ;

    private final int compareCount;
    private final int amount;

    Rank(int compareCount, int amount) {
        this.compareCount = compareCount;
        this.amount = amount;
    }

    public static Rank getRank(int count, boolean bonusContain) {
        return Arrays.stream(values())
                .filter(value -> value.isSameCount(count, bonusContain))
                .findFirst()
                .orElse(null);
    }

    public int getTotalAmount(int count) {
        return amount * count;
    }

    private static String getDisplayString(int compareCount, int amount, int count) {
        return compareCount + "개 일치 (" + String.format("%,d", amount) + "원) - " + count + "개";
    }

    private static String getDisplayBonusString(int compareCount, int amount, int count) {
        return compareCount + "개 일치, 보너스 볼 일치 (" + String.format("%,d", amount) + "원) - " + count + "개";
    }

}
