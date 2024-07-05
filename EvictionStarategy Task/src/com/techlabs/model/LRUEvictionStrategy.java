package com.techlabs.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUEvictionStrategy implements EvictionStrategy {
    @Override
    public void evict(Map<String, Integer> memoryMap, Map<String, Integer> accessCount, Map<String, Long> insertionOrder) {
        LinkedHashMap<String, Integer> lruMap = new LinkedHashMap<>(memoryMap);
        
        String keyToEvict = lruMap.keySet().iterator().next();
        
        memoryMap.remove(keyToEvict);
        accessCount.remove(keyToEvict);
        insertionOrder.remove(keyToEvict);
    }

	
}