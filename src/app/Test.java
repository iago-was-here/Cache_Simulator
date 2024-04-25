package app;

import java.util.ArrayList;
import java.util.Arrays;

import cache.StraightMapping;

public class Test {

	private String[] virtualAddressess;

	public Test(ArrayList<String> testFile) {
		for (int i = 0; i < testFile.size(); i++) {
			String lineContent = testFile.get(i);

			this.virtualAddressess = lineContent.split(",");
		}

	}

	public void StraightSearch() {
		
	}
}
