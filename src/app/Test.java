package app;

import java.util.ArrayList;

import helper.Binary;

public class Test {

	private int[] virtualAddresses;
	private int[][] realAddresses;

	public Test(ArrayList<String> testFile) {
		int testsAmount = testFile.size();
		this.virtualAddresses = new int[testsAmount];

		for (int i = 0; i < testsAmount; i++) {
			String lineContent = testFile.get(i);

			this.virtualAddresses[i] = Integer.parseInt(lineContent);
		}

	}

	public void StraightSearch() {

	}

	public int[] getVirtualAddresses() {
		return virtualAddresses;
	}

	public int[][] getRealAddresses() {
		return realAddresses;
	}

	public void setRealAddresses(int size) {
		int testsAmount = this.virtualAddresses.length;
		this.realAddresses = new int[testsAmount][size];
		
		for (int i = 0; i < testsAmount; i++) {
			int currentValue = this.virtualAddresses[i];

			this.realAddresses[i] = Binary.intToBinary(currentValue, size);
		}
	}
}
