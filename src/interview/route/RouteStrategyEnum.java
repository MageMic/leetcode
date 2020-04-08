package interview.route;

/**
 * @Author: zjumic
 * @Date: created at 14:15 2020/3/21
 */
public enum RouteStrategyEnum {

    // 随机负载均衡
    Random(0),
    // 轮询算法
    Polling(1),
    // 原地址hash算法
    HashIP(2);

    private int code;
    RouteStrategyEnum(int code) {
        this.code = code;
    }

    public static RouteStrategyEnum queryByCode(int code) {
        for (RouteStrategyEnum strategy : values()) {
            if (code == strategy.code) {
                return strategy;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
