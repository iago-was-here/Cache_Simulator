package app;

import java.util.ArrayList;
import java.util.Arrays;

import cache.AssociativeMapping;
import cache.StraightMapping;
import helper.FileManager;

public class App {
    public static void main(String[] args) {
        ArrayList<String> configFile;
        ArrayList<String> accessFile;

        configFile = FileManager.stringReader();
        accessFile = FileManager.stringReader();

        Config config = new Config(configFile);

        MemoryManagementUnit mmu = new MemoryManagementUnit(accessFile, config.getMainMemoryAddressBits());
        AssociativeMapping cache = new AssociativeMapping(config);

        int cacheHits = 0, cacheMisses = 0;

        for (String realAddress : mmu.getRealAddresses()) {
            String tag = realAddress.substring(0, (int) config.getTagBits()),
                    cacheRow = realAddress.substring((int) config.getTagBits(), (int) (config.getTagBits() + config.getCacheAdressBits())),
                    word = realAddress.substring((int) (config.getTagBits() + config.getCacheAdressBits()));

            if (cache.fetchWord(tag, cacheRow)) {
                cacheHits++;
                continue;
            }

            cacheMisses++;
        }

        int totalAccesses = cacheHits + cacheMisses;
        double hitPercentage = (double) (cacheHits * 100) / totalAccesses, missesPercentage = (double) (cacheMisses * 100) / totalAccesses;

        System.out.println(cacheHits);
        System.out.println(cacheMisses);
        System.out.println(hitPercentage);
        System.out.println(missesPercentage);

//        for (String cacheValue : cache.getCache()) {
//            System.out.println(cacheValue);
//        }
    }
}
