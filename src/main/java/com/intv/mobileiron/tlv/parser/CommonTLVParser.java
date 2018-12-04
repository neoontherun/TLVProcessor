package com.intv.mobileiron.tlv.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import com.intv.mobileiron.tlv.model.TLV;
import com.intv.mobileiron.tlv.util.TLVUtil;
import com.intv.mobileiron.tlv.validator.TLVValidator;
import com.intv.mobileiron.tlv.validator.Validator;

public class CommonTLVParser implements TLVParser {

	Validator tlvValidator = new TLVValidator();

	TLVUtil tlvUtil = new TLVUtil();

	@Override
	public List<TLV> parseData(List<String> tlvData) {
		List<String> reorderedTLVList = new ArrayList<String>();
		if (tlvData != null) {
			for (String tlvString : tlvData) {
				reorderedTLVList.addAll(reOrderInput(tlvString));
			}
		}
		return generateTLVList(reorderedTLVList);
	}

	private List<TLV> generateTLVList(List<String> reorderedTLVList) {
		List<TLV> tlvList = new ArrayList<TLV>();
		for (String tlvData : reorderedTLVList) {
			tlvList.add(tlvValidator.validate(tlvData));
		}
		return tlvList;
	}

	@Override
	public List<TLV> parseData(String[] tlvData) {
		return parseData(Arrays.asList(tlvData));
	}

	// Karthik - This will parse multiple tlv in single line. Currently it
	// doesn't manage unknown type with in same line. Inner method to can be refactored in to independent methods for reusability.
	public List<String> reOrderInput(String tlvString) {
		List<String> allTypes = tlvUtil.allTypeValues();
		// Karthik - Used treeset to maintain index ordering for handling
		// unknown types, but haven't completed the code.
		TreeSet<Integer> allIndexes = new TreeSet<Integer>();

		
		// Find all indexes in the string staring with known TYPEs.
		for (String type : allTypes) {
			for (int index = tlvString.indexOf(type); index >= 0; index = tlvString.indexOf(type, index + 1)) {
				allIndexes.add(index);
			}
		}
		List<String> splitStr = new ArrayList<String>();
		
		//The below code basically assumes that the line doesn't contain any unknown TYPES. This can be enhanced. Need time.
		if (!allIndexes.isEmpty()) {
			Integer[] allIndArr = new Integer[allIndexes.size()];
			allIndexes.toArray(allIndArr);
			for (int i = 0; i < allIndArr.length; i++) {
				if (i < allIndArr.length - 1) {
					splitStr.add(tlvString.substring(allIndArr[i], allIndArr[i + 1]));
				} else {
					splitStr.add(tlvString.substring(allIndArr[i], tlvString.length()));
				}
			}
		} else {
			splitStr.add(tlvString);
		}
		return splitStr;
	}

}
