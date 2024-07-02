package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {
    private long mainMemoryAddressBits;
    private long wordBits;
    private long cacheAddressBits;
    private long cacheRowQnt;
    private long cacheFullSize;
    private long wordFullSize;
    private long wordsByRow;
    private long tagSize;

    double kiloBytes = Math.pow(2, 10), megaBytes = this.kiloBytes * 1024,
            gigaBytes = this.megaBytes * 1024;

    public Config(ArrayList<String> configFile) {
        for (int i = 0; i < configFile.size(); i++) {
            String lineContent = configFile.get(i);
            String[] configInfo = lineContent.split(" = ");
            String[] currentInfo = configInfo[1].split(" ");

            System.out.println(Arrays.toString(configInfo));

            if (configInfo[0].equalsIgnoreCase("mem")) {
                this.setMainMemoryAddressBits(currentInfo);
            }

            if (configInfo[0].equalsIgnoreCase("palavra")) {
                this.setWordBits(currentInfo);
            }

            if (configInfo[0].equalsIgnoreCase("cache")) {
                this.setCacheAddressBits(currentInfo);
            }

            if (configInfo[0].equalsIgnoreCase("linha")) {
                this.setCacheRowQnt(Integer.parseInt(currentInfo[0]));
                this.wordsByRow = Integer.parseInt(currentInfo[0]);
            }
        }
        this.setTagSize();
    }

    public void setMainMemoryAddressBits(String[] mainMemoryCapacity) {
        long exponent = findExponent(mainMemoryCapacity[1]);
        long capacity = Integer.parseInt(mainMemoryCapacity[0]);
        long fullCapacity = capacity * exponent;

        this.mainMemoryAddressBits = (long) (Math.log(fullCapacity) / Math.log(2));
    }

    public void setWordBits(String[] wordSize) {
        long exponent = findExponent(wordSize[1]);
        long size = Integer.parseInt(wordSize[0]);
        long fullSize = size * exponent;

        this.wordFullSize = fullSize;

        this.wordBits = (long) (Math.log(fullSize) / Math.log(2));
    }

    public void setCacheAddressBits(String[] cacheSize) {
        long exponent = findExponent(cacheSize[1]);
        long size = Integer.parseInt(cacheSize[0]);
        long fullSize = size * exponent;

        this.cacheFullSize = fullSize;

        this.cacheAddressBits = (long) (Math.log(fullSize) / Math.log(2));
    }

    public void setCacheRowQnt(long wordsQntByLine) {
        long rowSize = wordsQntByLine * this.wordFullSize;
        this.cacheRowQnt = this.cacheFullSize / rowSize;
    }

    public long findExponent(String unitWithSemicolon) {
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

    public long getTagSize() {
        return tagSize;
    }

    public void setTagSize() {
        this.tagSize = (long) (this.mainMemoryAddressBits - (this.cacheAddressBits + this.wordBits));
    }
}
