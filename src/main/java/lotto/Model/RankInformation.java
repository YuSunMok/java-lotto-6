package lotto.Model;

public interface RankInformation {

    String getDisplayRankInfo(int count);

    boolean isSameCount(int count, boolean bonusContain);

}
