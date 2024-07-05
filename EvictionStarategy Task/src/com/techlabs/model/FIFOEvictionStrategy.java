package com.techlabs.model;

import java.util.Map;

public class FIFOEvictionStrategy implements EvictionStrategy {
    @Override
    public void evict(Map<String, Integer> memoryMap, Map<String, Integer> accessCount, Map<String, Long> insertionOrder) {
        String keyToEvict = null;
        long oldestInsertionTime = Long.MAX_VALUE;

        for (Map.Entry<String, Long> entry : insertionOrder.entrySet()) {
            String key = entry.getKey();
            long insertionTime = entry.getValue();
            if (insertionTime < oldestInsertionTime) {
                oldestInsertionTime = insertionTime;
                keyToEvict = key;
            }
        }

        if (keyToEvict != null) {
            memoryMap.remove(keyToEvict);
            accessCount.remove(keyToEvict);
            insertionOrder.remove(keyToEvict);
        }
    }

	
}