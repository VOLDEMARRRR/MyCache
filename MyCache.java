package com.example.cache.domain.dto;

import java.util.HashMap;
import java.util.Map;

public class MyCache {

    private final Map<String, String> cache = new HashMap<>();
    private final int maxSize;

    public MyCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String value) {
        cache.put(value, value);
        if (cache.size() > maxSize) {
            cache.remove(cache.keySet().iterator().next());
        }
    }

    public static void main(String[] args) {
        MyCache myCache = new MyCache(5);
        myCache.put("a");
        myCache.put("b");
        myCache.put("c");
        myCache.put("d");
        myCache.put("e");
        System.out.println(myCache.cache); // {a, b, c, d, e}
        myCache.put("f");
        System.out.println(myCache.cache); // {b, c, d, e, f}
        myCache.put("g");
        myCache.put("g");
        System.out.println(myCache.cache); // {c, d, e, f, g}
    }
}
