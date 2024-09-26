package lotto.Model;

import lotto.exception.LottoGameException;
import lotto.exception.LottoResultException;
import lotto.exception.LottosException;
import lotto.exception.RankException;

import java.util.*;

public class LottoResult {

    private final Map<Rank, Integer> lottoResultMap;

    private LottoResult(Map<Rank, Integer> lottoResultMap) {
        validateMap(lottoResultMap);
        this.lottoResultMap = initialize(lottoResultMap);
    }

    private void validateMap(Map<Rank, Integer> lottoResultMap) {
        if (isInValidMap(lottoResultMap)) {
            throw new LottoGameException(LottoResultException.INVALID_LOTTO_RESULT);
        }
    }

    public static LottoResult of(Map<Rank, Integer> lottoResultMap) {
        return new LottoResult(lottoResultMap);
    }

    public LottoResult reflectAt(Rank rank) {
        validateRank(rank);

        Map<Rank, Integer> map = new LinkedHashMap<>(lottoResultMap);
        map.put(rank, map.getOrDefault(rank, 0) + 1);

        return LottoResult.of(map);
    }

    public List<String> getLottoResultForDisplay() {
        List<String> list = new ArrayList<>();

        for (Rank rank : lottoResultMap.keySet()) {
            int count = getRankCount(rank);
            list.add(rank.getDisplayRankInfo(count));
        }

        return list;
    }

    public double getRateOfReturn(Lottos lottos) {
        validateLottos(lottos);
        
        int sum = getSumOfPrice();

        int purchasePrice = lottos.getPurchasePrice() ;

        return (double) sum / purchasePrice * 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResultMap, that.lottoResultMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResultMap);
    }

    private static Map<Rank, Integer> initialize(Map<Rank, Integer> lottoResultMap) {
        Map<Rank, Integer> map = new LinkedHashMap<>(lottoResultMap);
        Arrays.stream(Rank.values())
                .forEach(rank -> map.put(rank, map.getOrDefault(rank, 0)));

        return map;
    }

    private void validateRank(Rank rank) {
        if (rank == null) {
            throw new LottoGameException(RankException.INVALID_RANK);
        }
    }

    private void validateLottos(Lottos lottos) {
        if (isLottosInvalid(lottos)) {
            throw new LottoGameException(LottosException.INVALID_LOTTOS);
        }
    }

    private boolean isInValidMap(Map<Rank, Integer> lottoResultMap) {
        return lottoResultMap == null;
    }

    private boolean isLottosInvalid(Lottos lottos) {
        return lottos == null || lottos.isInvalid();
    }

    private int getSumOfPrice() {
        return lottoResultMap.keySet().stream()
                .mapToInt(rank -> rank.getTotalAmount(lottoResultMap.get(rank)))
                .sum();
    }

    private Integer getRankCount(Rank rank) {
        return lottoResultMap.get(rank);
    }

    public Map<Rank, Integer> getLottoResultMap() {
        return new HashMap<>(lottoResultMap);
    }

}
