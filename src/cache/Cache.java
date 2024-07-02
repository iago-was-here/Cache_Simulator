package cache;

import helper.Binary;

public abstract class Cache {
    protected String[][] cache;
    protected long rowsQnt;

    public Cache(long rowsQnt, long wordsByRow) {
        long depth = wordsByRow + 1; //add extra column to store the tag
        this.cache = new String[(int) rowsQnt][(int) depth];
        this.rowsQnt = (int) rowsQnt;
    }

    public String[][] getCache() {
        return cache;
    }

    public long getRowsQnt() {
        return rowsQnt;
    }
}

