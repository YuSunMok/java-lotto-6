package lotto.Model;

public interface RankInformation {

    String getInformation(int count);

    boolean isSameRank(int rank, boolean bonusContain);

}
