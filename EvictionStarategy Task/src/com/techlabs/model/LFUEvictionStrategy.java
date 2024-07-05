package com.techlabs.model;

import java.util.Map;

public class LFUEvictionStrategy implements EvictionStrategy {
    @Override
    public void evict(Map<String, Integer> memoryMap, Map<String, Integer> accessCount, Map<String, Long> insertionOrder) {
        String keyToEvict = null;
        int minAccessCount = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : accessCount.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            if (count < minAccessCount || (count == minAccessCount && insertionOrder.get(key) < insertionOrder.get(keyToEvict))) {
                minAccessCount = count;
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
