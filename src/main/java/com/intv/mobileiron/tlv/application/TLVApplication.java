package com.intv.mobileiron.tlv.application;

import java.io.IOException;
import java.util.List;

import com.intv.mobileiron.tlv.inputs.ConsoleInputReader;
import com.intv.mobileiron.tlv.output.ConsoleOutputWriter;
import com.intv.mobileiron.tlv.processor.TLVProcessor;

//Karthik - Haven't used spring to minimize the bundle.
public class TLVApplication {
	
	ConsoleInputReader ipReader = new ConsoleInputReader();
	
	TLVProcessor processor = new TLVProcessor();
	
	ConsoleOutputWriter opWriter = new ConsoleOutputWriter();
	
	public static void main(String[] args) throws IOException {
		//Karthik - For quicker check used the variables directly.
		System.out.println("Waiting for user input....");
		TLVApplication app = new TLVApplication();
		List<String> tlvData = app.ipReader.readData(null);
		app.processor.setTlvData(tlvData);
		StringBuilder output = app.processor.process();
		app.opWriter.writeData(output, System.out);
	}

}
