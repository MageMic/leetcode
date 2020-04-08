package interview.route;

import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 14:05 2020/3/21
 */
public interface RouteStrategy {

    <T> T select(List<T> primeList);

    default <T extends WeightGetAble> T selectWithWeight(List<T> primeList) {
        return select(WeightUtil.getWeightList(primeList));
    }
}
