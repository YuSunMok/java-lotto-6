package lotto.Model;

import java.util.*;

public class LottoResult {

    private final Map<Rank, Integer> lottoResultMap;

    private LottoResult(Map<Rank, Integer> lottoResultMap) {
        this.lottoResultMap = Collections.unmodifiableMap(new LinkedHashMap<>(lottoResultMap));
    }

    public static LottoResult of(Map<Rank, Integer> lottoResultMap) {
        if (isInValidMap(lottoResultMap)) {
            lottoResultMap = initialize();
        }

        return new LottoResult(lottoResultMap);
    }

    public LottoResult reflectAt(Rank rank) {
        Map<Rank, Integer> map = new LinkedHashMap<>(lottoResultMap);
        map.put(rank, map.get(rank) + 1);

        return LottoResult.of(map);
    }

    public List<String> getRankInformation() {
        List<String> list = new ArrayList<>();

        for (Rank rank : lottoResultMap.keySet()) {
            int count = lottoResultMap.get(rank);
            list.add(rank.getInformation(count));
        }

        return list;
    }

    public double getRateOfReturn(Lottos lottos) {
        int sum = lottoResultMap.keySet().stream()
                .mapToInt(rank -> rank.getTotalAmount(lottoResultMap.get(rank)))
                .sum();

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

    private static boolean isInValidMap(Map<Rank, Integer> lottoResultMap) {
        return lottoResultMap == null || lottoResultMap.isEmpty();
    }

    private static Map<Rank, Integer> initialize() {
        Map<Rank, Integer> map = new LinkedHashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> map.put(rank, 0));

        return map;
    }

}
