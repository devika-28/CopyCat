package com.devika.buffer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class InputBuffer {

	public ArrayList<String> insertFile(String path) throws IOException {

		BufferedReader buffer = new BufferedReader(new FileReader(path));
		String nextLine;
		ArrayList<String> ls = new ArrayList<String>();
		while ((nextLine = buffer.readLine()) != null) {
			String[] temp = nextLine.split(":|;|\\)\\s|\"|\\.\\s|,\\s,/");
			for (String i : temp) {
				ls.add(ls.size(), i);
			}
		}
		buffer.close();
		return ls;
	}

	public ArrayList<String> processText(String data) {
		String[] temp = data.split(":|;|\\)\\s|\"|\\.\\s|,\\s,/");
		ArrayList<String> ls = new ArrayList<String>();
		for (String i : temp) {
			ls.add(ls.size(), i);
		}
		return ls;
	}
}
