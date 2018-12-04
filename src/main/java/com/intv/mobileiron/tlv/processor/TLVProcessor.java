package com.intv.mobileiron.tlv.processor;

import java.util.List;

import com.intv.mobileiron.tlv.enums.Type;
import com.intv.mobileiron.tlv.model.TLV;
import com.intv.mobileiron.tlv.parser.CommonTLVParser;
import com.intv.mobileiron.tlv.parser.TLVParser;
import com.intv.mobileiron.tlv.util.TLVConstants;

public class TLVProcessor {
	
	List<String> tlvData;
	
	TLVParser parser = new CommonTLVParser();
	
	public TLVProcessor(List<String> tlvData) {
		super();
		this.tlvData = tlvData;
	}
	
	public TLVProcessor() {
	}

	public StringBuilder process() {
		List<TLV> tlvList = parser.parseData(tlvData);
		StringBuilder output = new StringBuilder();
		for (TLV tlv : tlvList) {
			if (Type.UPPRCS.equals(tlv.getType()) || Type.REPLCE.equals(tlv.getType())) {
				output.append(tlv.getType().toString()).append(TLVConstants.HYPHEN_DELIMITER);
				if (Type.UPPRCS.equals(tlv.getType())) {
					output.append(tlv.getValue().toUpperCase()).append(TLVConstants.NEW_LINE);
				} else if (Type.REPLCE.equals(tlv.getType())) {
					output.append(TLVConstants.REPLACE_STRING).append(TLVConstants.NEW_LINE);
				}
			} else {
				output.append(TLVConstants.ERROR_MSG).append(TLVConstants.NEW_LINE);
			}
		}
		return output;
	}

	public List<String> getTlvData() {
		return tlvData;
	}

	public void setTlvData(List<String> tlvData) {
		this.tlvData = tlvData;
	}
	
}