package interview.route;

/**
 * @Author: zjumic
 * @Date: created at 14:06 2020/3/21
 */
// 权重接口，使用权重负载均衡的列表元素必须实现此接口
public interface WeightGetAble {

    default int getWeightFactors() {
        return 1;
    }
}
