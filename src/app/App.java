package app;

import java.util.ArrayList;
import java.util.Arrays;

import helper.FileManager;

public class App {
	public static void main(String[] args) {
		ArrayList<String> configFile = new ArrayList<String>();
		ArrayList<String> testFile = new ArrayList<String>();

		configFile = FileManager.stringReader("/C://Users//BMS//Desktop//OAC_Files//config.txt/");
		testFile = FileManager.stringReader("/C://Users//BMS//Desktop//OAC_Files//teste_1.txt/");

		Config config = new Config(configFile);
		Test test = new Test(testFile);

		System.out.println(config.getMainMemoryAddressBits());
		System.out.println(config.getWordSize());
		System.out.println(config.getCacheAdressBits());
		System.out.println(config.getWordsQntByLine());
		System.out.println();

		test.setRealAddresses((int) config.getMainMemoryAddressBits());
		System.out.println(Arrays.deepToString(test.getRealAddresses()));
	}
}
