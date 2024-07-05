package com.techlabs.model;

import java.util.Map;

public interface EvictionStrategy {

	void evict(Map<String, Integer> memoryMap, Map<String, Integer> accessCount, Map<String, Long> insertionOrder);
}
