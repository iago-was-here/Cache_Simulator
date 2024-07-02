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

        configFile = FileManager.stringReader("/C://Users//iagoa//Desktop//Projetos//OAC//config.txt/");
        accessFile = FileManager.stringReader("/C://Users//iagoa//Desktop//Projetos//OAC//teste_1.txt/");

        Config config = new Config(configFile);

        MemoryManagementUnit mmu = new MemoryManagementUnit(accessFile);
        StraightMapping cache = new StraightMapping(config);

        mmu.setRealAddresses(config.getMainMemoryAddressBits());


        int cacheHits = 0, cacheMisses = 0;

        for (String realAddress : mmu.getRealAddresses()) {
            String tag = realAddress.substring(0, (int) config.getTagSize()),
                    cacheRow = realAddress.substring((int) config.getTagSize(), (int) (config.getTagSize() + config.getCacheAdressBits())),
                    word = realAddress.substring((int) (config.getTagSize() + config.getCacheAdressBits()));

            if (cache.fetchWord(tag, cacheRow, word)) {
                cacheHits++;
                continue;
            }

            cacheMisses++;
        }

        System.out.println(cacheHits);
        System.out.println(cacheMisses);
        for (String[] cacheValue : cache.getCache()) {
            System.out.println(Arrays.toString(cacheValue));
        }
    }
}
