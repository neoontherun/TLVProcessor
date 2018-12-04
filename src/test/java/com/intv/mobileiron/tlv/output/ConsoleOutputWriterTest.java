package com.intv.mobileiron.tlv.output;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleOutputWriterTest {

	ConsoleOutputWriter objectUnderTest = new ConsoleOutputWriter();

	@Test
	public void test() {
		try {
			objectUnderTest.writeData("Some Junk", System.out);
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
