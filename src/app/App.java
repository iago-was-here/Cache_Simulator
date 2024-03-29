package app;

import java.util.ArrayList;

import helper.FileManager;

public class App {
	public static void main(String[] args) {		 
		ArrayList<String> configFile = new ArrayList<String>();
		ArrayList<String> testFile = new ArrayList<String>();

		configFile = FileManager.stringReader("C:/Users/iagoa/Desktop/Projetos/OAC/test.txt");
		testFile = FileManager.stringReader("C:/Users/iagoa/Desktop/Projetos/OAC/teste_1.txt");
		
		System.out.println(configFile.toString());
		System.out.println(testFile.toString());
	}
}
