package com.intv.mobileiron.tlv.validator;

import com.intv.mobileiron.tlv.enums.Type;
import com.intv.mobileiron.tlv.model.TLV;
import com.intv.mobileiron.tlv.util.TLVConstants;

public class TLVValidator implements Validator {

	@Override
	public TLV validate(String data) {
		String[] splitData = data.split(TLVConstants.HYPHEN_DELIMITER, 3);
		TLV tlvData = new TLV();
		boolean isValid = true;
		if (splitData.length > 2) {
			String type = splitData[0];
			Type parsedType;
			try {
				parsedType = Type.valueOf(type);
				tlvData.setType(Type.valueOf(type));
				String valueLength = splitData[1];
				try {
					int valLen = Integer.parseInt(valueLength);
					tlvData.setLength(valLen);
					tlvData.setValue(splitData[2]);
					if (splitData[2].length() != valLen) {
						isValid = false;
					}
				} catch (Exception e) {
					isValid = false;
				}
			} catch (Exception e) {
				isValid = false;
			}
		}
		if (!isValid && tlvData.getType() == null) {
			tlvData.setType(Type.UNKNOWN);
		}
		tlvData.setIsValid(isValid);
		return tlvData;
	}
}
