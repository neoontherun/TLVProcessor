package com.intv.mobileiron.tlv.inputs;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleInputReaderTest {
	
	ConsoleInputReader objectUnderTest = new ConsoleInputReader();
	
//	@Test
	public void test() {
		try {
			List<String> readData = objectUnderTest.readData(null);
			System.out.println(readData);
		} catch (IOException e) {
			Assert.fail();
		}
	}

}
