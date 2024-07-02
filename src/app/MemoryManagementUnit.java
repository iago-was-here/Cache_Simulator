package app;

import java.util.ArrayList;

import helper.Binary;

public class MemoryManagementUnit {

	private final int[] virtualAddresses;
	private String[] realAddresses;

	public MemoryManagementUnit(ArrayList<String> accessFile) {
		int accessAmount = accessFile.size();
		this.virtualAddresses = new int[accessAmount];

		for (int i = 0; i < accessAmount; i++) {
			String lineContent = accessFile.get(i);

			this.virtualAddresses[i] = Integer.parseInt(lineContent);
		}
	}

	public void setRealAddresses(long size) {
		int testsAmount = this.virtualAddresses.length;
		this.realAddresses = new String[testsAmount];

		for (int i = 0; i < testsAmount; i++) {
			int currentValue = this.virtualAddresses[i];

			this.realAddresses[i] = Binary.intToBinaryString(currentValue, (int) size);
		}
	}

	public String[] getRealAddresses() {
		return realAddresses;
	}
}
