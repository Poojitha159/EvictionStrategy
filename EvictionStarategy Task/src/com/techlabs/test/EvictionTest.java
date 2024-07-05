package com.techlabs.test;

import com.techlabs.model.CustomMemoryMap;
import com.techlabs.model.EvictionStrategy;
import com.techlabs.model.FIFOEvictionStrategy;
import com.techlabs.model.LFUEvictionStrategy;
import com.techlabs.model.LRUEvictionStrategy;

public class EvictionTest {

	public static void main(String[] args) {


		EvictionStrategy fifoStrategy = new FIFOEvictionStrategy();
        CustomMemoryMap memoryMapFIFO = new CustomMemoryMap(3, fifoStrategy);

        memoryMapFIFO.put("a");
        memoryMapFIFO.put("b");
        memoryMapFIFO.put("a");
        memoryMapFIFO.put("c");
        memoryMapFIFO.get("b");
        memoryMapFIFO.get("b");
        memoryMapFIFO.get("a");
        memoryMapFIFO.get("a");
        memoryMapFIFO.get("c");
        memoryMapFIFO.get("a");

        memoryMapFIFO.put("d");

        System.out.println("FIFO: " + memoryMapFIFO.getMemoryMap());

        // Use LRU Strategy
        EvictionStrategy lruStrategy = new LRUEvictionStrategy();
        CustomMemoryMap memoryMapLRU = new CustomMemoryMap(3, lruStrategy);

        memoryMapLRU.put("a");
        memoryMapLRU.put("b");
        memoryMapLRU.put("c");

        memoryMapLRU.get("b");
        memoryMapLRU.get("b");
        memoryMapLRU.get("a");
        memoryMapLRU.get("a");
        memoryMapLRU.get("c");
        memoryMapLRU.get("a");

        memoryMapLRU.put("d");

        System.out.println("LRU: " + memoryMapLRU.getMemoryMap());

        // Use LFU Strategy
        EvictionStrategy lfuStrategy = new LFUEvictionStrategy();
        CustomMemoryMap memoryMapLFU = new CustomMemoryMap(3, lfuStrategy);

        memoryMapLFU.put("a");
        memoryMapLFU.put("b");
        memoryMapLFU.put("c");

        memoryMapLFU.get("b");
        memoryMapLFU.get("b");
        memoryMapLFU.get("a");
        memoryMapLFU.get("a");
        memoryMapLFU.get("c");
        memoryMapLFU.get("a");

        memoryMapLFU.put("d");

        System.out.println("LFU: " + memoryMapLFU.getMemoryMap());
    }
}
	
