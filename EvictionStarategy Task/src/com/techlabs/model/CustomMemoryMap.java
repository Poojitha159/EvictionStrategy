package com.techlabs.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomMemoryMap {
	private final Map<String, Integer> memoryMap = new LinkedHashMap<>();
    private final Map<String, Integer> accessCount = new HashMap<>();
    private final Map<String, Long> insertionOrder = new HashMap<>();
    private final int capacity;
    private final EvictionStrategy evictionStrategy;
    private long currentTime;

    public CustomMemoryMap(int capacity, EvictionStrategy evictionStrategy) {
        this.capacity = capacity;
        this.evictionStrategy = evictionStrategy;
        this.currentTime = System.currentTimeMillis();
    }

    public void put(String key) {
        if (memoryMap.size() >= capacity) {
            evictionStrategy.evict(memoryMap, accessCount, insertionOrder);
        }
        memoryMap.put(key, 0);
        accessCount.put(key, 0);
        insertionOrder.put(key, currentTime++);
    }

    public void get(String key) {
        if (memoryMap.containsKey(key)) {
            memoryMap.put(key, memoryMap.get(key) + 1);
            accessCount.put(key, accessCount.get(key) + 1);
            insertionOrder.put(key, currentTime++);
        }
    }

    public Map<String, Integer> getMemoryMap() {
        return memoryMap;
    }

}
