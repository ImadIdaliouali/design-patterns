package org.example;

import java.util.HashMap;
import java.util.Map;

public class Proxy implements Service {
    ServiceImpl serviceImpl = new ServiceImpl();
    Map<Integer, Double> cacheMap = new HashMap<>();

    @Override
    public double calculate(int n) {
        if (cacheMap.containsKey(n)) {
            System.out.println("cache hit");
            double res = cacheMap.get(n);
            System.out.println(res);
            return res;
        } else {
            double res = serviceImpl.calculate(n);
            cacheMap.put(n, res);
            System.out.println(res);
            return res;
        }
    }
}
