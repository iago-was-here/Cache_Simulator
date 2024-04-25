package cache;

import app.Config;

public class StraightMapping extends Cache{

	public StraightMapping(Config config) {
		super();
		Long[] cache = new Long[(int) config.getCacheAdressBits()];
	}
	@Override
	public Boolean fetchWord(int address, int tag) {
		return null;
	}
	@Override
	public void replace() {
		
	}

}
