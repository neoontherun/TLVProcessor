package com.intv.mobileiron.tlv.inputs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInputReader implements TLVInputReader {

	@Override
	public List<String> readData(String input) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		List<String> userInput = new ArrayList<String>();
		while ((line = in.readLine()) != null && line.length() != 0) {
			userInput.add(line);
//			System.out.println(line);
		}
		return userInput;
	}

}
