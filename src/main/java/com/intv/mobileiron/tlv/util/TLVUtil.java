package com.intv.mobileiron.tlv.util;

import java.util.ArrayList;
import java.util.List;

import com.intv.mobileiron.tlv.enums.Type;

public class TLVUtil {

	List<String> allTypeValues;

	public List<String> allTypeValues() {
		// Karthik - This can be made thread safe too. Currently skipping it.
		if (allTypeValues == null) {
			allTypeValues = new ArrayList<String>();
			for (Type type : Type.values()) {
				allTypeValues.add(type.toString());
			}
		}
		return allTypeValues;
	}

}
