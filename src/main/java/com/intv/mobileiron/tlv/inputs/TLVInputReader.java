package com.intv.mobileiron.tlv.inputs;

import java.io.IOException;
import java.util.List;

public interface TLVInputReader {
	
	public List<String> readData(String input) throws IOException;

}
