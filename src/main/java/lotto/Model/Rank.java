package lotto.Model;

import java.util.Arrays;

import static lotto.config.LottoGameConfig.*;

public enum Rank implements RankInformation {

    FIFTH_PLACE(FIFTH_PLACE_COMPARE_COUNT, FIFTH_PLACE_AMOUNT) {

        @Override
        public String getInformation(int count) {
            return getString(FIFTH_PLACE.compareCount, FIFTH_PLACE.amount, count);
        }

        @Override
        public boolean isSameRank(int rank, boolean bonusContain) {
            return rank == FIFTH_PLACE.compareCount;
        }
    },
    FOURTH_PLACE(FOURTH_PLACE_COMPARE_COUNT, FOURTH_PLACE_AMOUNT) {

        @Override
        public String getInformation(int count) {
            return getString(FOURTH_PLACE.compareCount, FOURTH_PLACE.amount, count);
        }

        @Override
        public boolean isSameRank(int rank, boolean bonusContain) {
            return rank == FOURTH_PLACE.compareCount;
        }
    },
    THIRD_PLACE(THIRD_PLACE_COMPARE_COUNT, THIRD_PLACE_AMOUNT) {

        @Override
        public String getInformation(int count) {
            return getString(THIRD_PLACE.compareCount, THIRD_PLACE.amount, count);
        }

        @Override
        public boolean isSameRank(int rank, boolean bonusContain) {
            return rank == THIRD_PLACE.compareCount && !bonusContain;
        }
    },
    SECOND_PLACE(SECOND_PLACE_COMPARE_COUNT, SECOND_PLACE_AMOUNT) {

        @Override
        public String getInformation(int count) {
            return getBonusString(SECOND_PLACE.compareCount, SECOND_PLACE.amount, count);
        }

        @Override
        public boolean isSameRank(int rank, boolean bonusContain) {
            return rank == SECOND_PLACE.compareCount && bonusContain;
        }
    },
    FIRST_PLACE(FIRST_PLACE_COMPARE_COUNT, FIRST_PLACE_AMOUNT) {

        @Override
        public String getInformation(int count) {
            return getString(FIRST_PLACE.compareCount, FIRST_PLACE.amount, count);
        }

        @Override
        public boolean isSameRank(int rank, boolean bonusContain) {
            return rank == FIRST_PLACE.compareCount;
        }
    },
    ;

    private final int compareCount;
    private final int amount;

    Rank(int compareCount, int amount) {
        this.compareCount = compareCount;
        this.amount = amount;
    }

    public static Rank getRank(int rank, boolean bonusContain) {
        return Arrays.stream(values())
                .filter(value -> value.isSameRank(rank, bonusContain))
                .findFirst()
                .orElse(null);
    }

    public int getTotalAmount(int count) {
        return amount * count;
    }

    private static String getString(int compareCount, int amount, int count) {
        return compareCount + "개 일치 (" + String.format("%,d", amount) + "원) - " + count + "개";
    }

    private static String getBonusString(int compareCount, int amount, int count) {
        return compareCount + "개 일치, 보너스 볼 일치 (" + String.format("%,d", amount) + "원) - " + count + "개";
    }
}
