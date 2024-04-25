package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {
	private double mainMemoryAddressBits;
	private double wordSize;
	private double cacheAddressBits;
	private int wordsQntByLine;

	double kiloBytes = Math.pow(2, 10), megaBytes = this.kiloBytes * (Math.pow(10, 6)),
			gigaBytes = this.megaBytes * (Math.pow(10, 9));

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
				this.setWordsQntByLine(Integer.parseInt(currentInfo[0]));
			}

		}
	}

	public void setMainMemoryAddressBits(String[] mainMemoryCapacity) {
		double exponent = findExponent(mainMemoryCapacity[1]);
		int capacity = Integer.parseInt(mainMemoryCapacity[0]);
		double fullCapacity = capacity * exponent;

		this.mainMemoryAddressBits = Math.log(fullCapacity) / Math.log(2);
	}

	public void setWordBits(String[] wordSize) {
		double exponent = findExponent(wordSize[1]);
		int size = Integer.parseInt(wordSize[0]);
		double fullSize = size * exponent;

		this.wordSize = Math.log(fullSize) / Math.log(2);
	}

	public void setCacheAddressBits(String[] cacheSize) {
		double exponent = findExponent(cacheSize[1]);
		int size = Integer.parseInt(cacheSize[0]);
		double fullSize = size * exponent;

		this.cacheAddressBits = Math.log(fullSize) / Math.log(2);
	}

	public void setWordsQntByLine(int wordsQntByLine) {
		this.wordsQntByLine = wordsQntByLine;
	}

	public double findExponent(String unitWithSemicolon) {
		String[] unit = unitWithSemicolon.split(";");
		if (unit[0].equalsIgnoreCase("KB")) {
			return this.kiloBytes;
		}

		if (unit[0].equalsIgnoreCase("MB")) {
			return this.megaBytes;
		}

		if (unit[0].equalsIgnoreCase("GB")) {
			return this.gigaBytes;
		}
		return 1;
	}

	public double getMainMemoryAddressBits() {
		return mainMemoryAddressBits;
	}

	public int getWordsQntByLine() {
		return wordsQntByLine;
	}

	public double getCacheAdressBits() {
		return cacheAddressBits;
	}

	public double getWordSize() {
		return wordSize;
	}
}
