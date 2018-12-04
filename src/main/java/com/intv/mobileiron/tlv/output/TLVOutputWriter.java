package com.intv.mobileiron.tlv.output;

import java.io.OutputStream;

public interface TLVOutputWriter {
	
	public boolean writeData(StringBuilder data, OutputStream output);
	
	public boolean writeData(String data, OutputStream output);

}
