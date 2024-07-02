package cache;

import app.Config;

import java.util.Arrays;

public class StraightMapping extends Cache {

    public StraightMapping(Config config) {
        super(config.getCacheRowQnt(), config.getWordsByRow());
    }

    public boolean fetchWord(String tag, String cacheRow, String word) {
        long cacheRowNumber = (Integer.parseInt(cacheRow, 2) % this.getRowsQnt()), columnCounter = 0;
        boolean found = false;

        replace(cacheRowNumber, columnCounter, tag);
        String[] currentCacheRow = super.getCache()[(int) cacheRowNumber];

        if (currentCacheRow[0] != null && currentCacheRow[0].equals(tag)) {
            for (int i = 1; i < currentCacheRow.length; i++) {
                if (currentCacheRow[i] != null) {
                    found = currentCacheRow[i].equals(word);
                }
            }
        }


        for (String cacheValue : super.getCache()[(int) cacheRowNumber]) {
            if (cacheValue != null) {
                found = word.equals(cacheValue);
            }
        }

        return found;
    }

    public void replace(long cacheRowNumber, long column, String cacheValue) {
        super.getCache()[(int) cacheRowNumber][(int) column] = cacheValue;
    }

}
