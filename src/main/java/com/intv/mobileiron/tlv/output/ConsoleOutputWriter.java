package com.intv.mobileiron.tlv.output;

import java.io.OutputStream;
import java.io.PrintStream;

import com.intv.mobileiron.tlv.util.TLVConstants;

public class ConsoleOutputWriter implements TLVOutputWriter {

	@Override
	public boolean writeData(StringBuilder data, OutputStream output) {
		addHeaderInfo(data);
		if (output instanceof PrintStream) {
			((PrintStream) output).print(data);
			return true;
		}
		return false;
	}

	private void addHeaderInfo(StringBuilder data) {
		data.insert(0, TLVConstants.OUTPUT_HEADER);
		
	}

	@Override
	public boolean writeData(String data, OutputStream output) {
		return writeData(new StringBuilder(data), output);
	}

}
