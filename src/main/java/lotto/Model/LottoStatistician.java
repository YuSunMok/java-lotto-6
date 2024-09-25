package lotto.Model;

import java.util.List;
import java.util.Optional;

public class LottoStatistician {

    public LottoResult statistic(Lottos lottos, Lotto winningLotto, int bonusNumber) {
        LottoResult lottoResult = LottoResult.of(null);
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            Optional<Rank> optionalRank = winningLotto.compareAt(lotto, bonusNumber);
            if (optionalRank.isPresent()) {
                Rank rank = optionalRank.get();
                lottoResult = lottoResult.reflectAt(rank);
            }
        }
        return lottoResult;
    }

}
