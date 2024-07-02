package cache;

import app.Config;

public class AssociativeMapping extends Cache {

    public AssociativeMapping(Config config) {
        super(config.getCacheRowQnt(), config.getWordsByRow());
    }

    public boolean fetchWord(String tag, String word) {
        boolean found = false;

        for (long i = 0; i < super.getCache().length; i++) {
            String[] cureentRow = super.getCache()[(int) i];
            for (long j = 1; j < cureentRow.length; j++) {
                String currentValue = super.getCache()[(int) i][(int) j];
                if (currentValue != null) {
                    found = currentValue.equals(word);
                }
            }
        }



        return found;
    }

    public void replace(long cacheRowNumber, long column, String value) {
        super.getCache()[(int) cacheRowNumber][(int) column] = value;
    }
}
