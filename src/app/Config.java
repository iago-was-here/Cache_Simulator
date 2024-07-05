package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {
    private long mainMemoryAddressBits;
    private long wordBits;
    private long cacheAddressBits;
    private long cacheRowQnt;
    private long wordsByRow;
    private long tagBits;
    protected long mainMemorySize;
    private long cacheFullSize;
    private long wordFullSize;


    double kiloBytes = Math.pow(2, 10), megaBytes = this.kiloBytes * 1024,
            gigaBytes = this.megaBytes * 1024;

    public Config(ArrayList<String> configFile) {
        for (int i = 0; i < configFile.size(); i++) {
            String lineContent = configFile.get(i);
            String[] configInfo = lineContent.split(" = ");
            String[] currentInfo = configInfo[1].split(" ");

            System.out.println(Arrays.toString(configInfo));

            if (configInfo[0].equalsIgnoreCase("mem")) {
                this.mainMemorySize = this.calculateFullSize(currentInfo);
            }

            if (configInfo[0].equalsIgnoreCase("palavra")) {
                this.wordFullSize = this.calculateFullSize(currentInfo);
            }

            if (configInfo[0].equalsIgnoreCase("cache")) {
                this.cacheFullSize = this.calculateFullSize(currentInfo);
            }

            if (configInfo[0].equalsIgnoreCase("linha")) {
                this.setCacheRowQnt(Integer.parseInt(currentInfo[0]));
                this.wordsByRow = Integer.parseInt(currentInfo[0]);
            }
        }

        this.setMainMemoryAddressBits();
        this.setCacheAddressBits();
        this.setWordBits();
        this.setTagBits();
    }

    protected void setMainMemoryAddressBits() {
        long mainMemoryRowsQnt = this.mainMemorySize/this.wordFullSize;
        this.mainMemoryAddressBits = (long) (Math.log(mainMemoryRowsQnt) / Math.log(2));
    }

    public void setCacheAddressBits() {
        this.cacheAddressBits = (long) (Math.log(this.cacheRowQnt) / Math.log(2));
    }

    public void setWordBits() {
        this.wordBits = (long) (Math.log(this.wordFullSize) / Math.log(2));
    }

    public void setTagBits() {
        this.tagBits = (long) (this.mainMemoryAddressBits - (this.cacheAddressBits + this.wordBits));
    }

    public void setCacheRowQnt(long wordsQntByLine) {
        long rowSize = wordsQntByLine * this.wordFullSize;
        this.cacheRowQnt = this.cacheFullSize / rowSize;
    }

    protected long calculateFullSize(String[] value){
        long exponent = findExponent(value[1]);
        long size = Integer.parseInt(value[0]);

        return size * exponent;
    }

    protected long findExponent(String unitWithSemicolon) {
        String[] unit = unitWithSemicolon.split(";");
        if (unit[0].equalsIgnoreCase("KB")) {
            return (long) this.kiloBytes;
        }

        if (unit[0].equalsIgnoreCase("MB")) {
            return (long) this.megaBytes;
        }

        if (unit[0].equalsIgnoreCase("GB")) {
            return (long) this.gigaBytes;
        }
        return 1;
    }

    public long getMainMemoryAddressBits() {
        return mainMemoryAddressBits;
    }

    public long getCacheRowQnt() {
        return cacheRowQnt;
    }

    public long getCacheAdressBits() {
        return cacheAddressBits;
    }

    public long getWordBits() {
        return wordBits;
    }

    public long getWordsByRow() {
        return wordsByRow;
    }

    public long getTagBits() {
        return tagBits;
    }
}
