package cache;

import app.Config;

import java.util.ArrayList;
import java.util.HashMap;

public class AssociativeMapping extends Cache {
    protected HashMap<Long, String> cache;

    public AssociativeMapping(Config config) {
        this.cache = new HashMap<Long, String>();
    }

    public boolean fetchWord(String tag, String cacheRow) {
        long cacheRowNumber = Long.parseLong(cacheRow, 2);
        boolean found = this.cache.containsValue(tag);

        if (!found) {
            replace(cacheRowNumber, tag);
        }

        return found;
    }

    public void replace(long cacheRowNumber, String value) {
        this.cache.put(cacheRowNumber, value);
    }
}
