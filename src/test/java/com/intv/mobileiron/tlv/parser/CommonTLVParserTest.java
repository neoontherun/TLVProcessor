package com.intv.mobileiron.tlv.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.intv.mobileiron.tlv.model.TLV;

public class CommonTLVParserTest {

	CommonTLVParser objectUnderTest = new CommonTLVParser();

	@Test
	public void test() {
		String[] tlvData = { "UPPRCS-0005-abcde", "REPLCE-0003-123", "UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z", "TAG001-0012-abcdefgh1234", "UPPRCS-0004-1234", "UPPRCS-0003-xyzTAGTES-0003-tesREPLCE-0002-HI" };
//		String[] tlvData = { "UPPRCS-0003-xyzTAGTES-0003-tesREPLCE-0002-HI" };
		List<TLV> response = objectUnderTest.parseData(tlvData);
		System.out.println(response);
		System.out.println(response.size());
		assertNotNull(response);
		assertEquals(response.size(), 9);
	}
	
	public static void main(String[] args) {
		CommonTLVParserTest test = new CommonTLVParserTest();
		test.test();
	}

}
