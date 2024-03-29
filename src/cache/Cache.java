package cache;

public abstract class Cache {
	private int size;
	private int addressSize;
	private int rowsQnt;
	private int wordsByline;

	public abstract Boolean fetchWord(int address, int tag);

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getRowsQnt() {
		return rowsQnt;
	}

	public void setRowsQnt(int rowsQnt) {
		this.rowsQnt = rowsQnt;
	}

	public int getWordsByline() {
		return wordsByline;
	}

	public void setWordsByline(int wordsByline) {
		this.wordsByline = wordsByline;
	}

	public int getAddressSize() {
		return addressSize;
	}

	public void setAddressSize(int addressSize) {
		this.addressSize = addressSize;
	}
}
