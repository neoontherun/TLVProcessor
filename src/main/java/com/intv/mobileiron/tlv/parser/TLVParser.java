package com.intv.mobileiron.tlv.parser;

import java.util.List;

import com.intv.mobileiron.tlv.model.TLV;

public interface TLVParser {
	
	public List<TLV> parseData(List<String> tlvData);
	
	public List<TLV> parseData(String[] tlvData);

}
