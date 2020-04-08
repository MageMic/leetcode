package interview.route.impl;

import interview.route.RouteStrategy;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;

/**
 * @Author: zjumic
 * @Date: created at 14:33 2020/3/21
 */
public class HashIPRouteStrategyImpl implements RouteStrategy {
    @Override
    public <T> T select(List<T> primeList) {
        String localIP = null;
        try {
            localIP = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        if (localIP == null) {
            Random r = new Random();
            byte[] result = new byte[5];
            r.nextBytes(result);
            localIP = result.toString();
        }

        int hashCode = localIP.hashCode();
        int size = primeList.size();

        return primeList.get(Math.abs(hashCode) % size);
    }
}
