package com.intv.mobileiron.tlv.validator;

import com.intv.mobileiron.tlv.model.TLV;

public interface Validator {
	
	public TLV validate(String data);

}
