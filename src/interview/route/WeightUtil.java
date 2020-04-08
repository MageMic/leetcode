package interview.route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 14:09 2020/3/21
 */
public enum WeightUtil {
    INSTANCE;
    public static <T extends WeightGetAble> List<T> getWeightList(List<T> primeList) {
        List<T> weightList = new ArrayList<>();
        for (T prime : primeList) {
            int weight = prime.getWeightFactors();
            for (int i = 0; i < weight; i++) {
                weightList.add(prime);
            }
        }
        return weightList;
    }
}
