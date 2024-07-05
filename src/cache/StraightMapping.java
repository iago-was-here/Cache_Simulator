package cache;

import app.Config;

import java.util.Arrays;

public class StraightMapping extends Cache {

    protected String[] cache;
    public StraightMapping(Config config) {
        this.cache = new String[(int) config.getCacheRowQnt()];
    }

    public boolean fetchWord(String tag, String cacheRow) {
        long cacheRowNumber = Integer.parseInt(cacheRow, 2);
        boolean found = false;

        String currentCacheRow = this.cache[(int) cacheRowNumber];

        if (currentCacheRow != null) {
            found = currentCacheRow.equals(tag);
        }

        replace(cacheRowNumber, tag);

        return found;
    }

    public void replace(long cacheRowNumber, String cacheValue) {
        this.cache[(int) cacheRowNumber] = cacheValue;
    }

}
