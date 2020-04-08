package interview.route.impl;

import interview.route.RouteStrategy;

import java.util.List;
import java.util.Random;

/**
 * @Author: zjumic
 * @Date: created at 14:20 2020/3/21
 */
public class RandomRouteStrategyImpl implements RouteStrategy {
    @Override
    public <T> T select(List<T> primeList) {
        Random r = new Random();
        return primeList.get(r.nextInt(primeList.size()));
    }
}
