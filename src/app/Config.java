package app;

public class Config {
	private int mainMemoryCapacity;
	private int wordSize;
	private int cacheSize;
	private int wordsQntByLine;

	public int getMainMemoryCapacity() {
		return mainMemoryCapacity;
	}

	public void setMainMemoryCapacity(int mainMemoryCapacity) {
		this.mainMemoryCapacity = mainMemoryCapacity;
	}

	public int getWordSize() {
		return wordSize;
	}

	public void setWordSize(int wordSize) {
		this.wordSize = wordSize;
	}

	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public int getWordsQntByLine() {
		return wordsQntByLine;
	}

	public void setWordsQntByLine(int wordsQntByLine) {
		this.wordsQntByLine = wordsQntByLine;
	}
}
