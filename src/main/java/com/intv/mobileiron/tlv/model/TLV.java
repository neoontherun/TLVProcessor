package com.intv.mobileiron.tlv.model;

import com.intv.mobileiron.tlv.enums.Type;

public class TLV {

	Type type;
	Integer length;
	String value;
	// This flag is added to ensure there is no double processing done after validate function.
	Boolean isValid;
	
	public TLV() {}
	
	public TLV(Type type, Integer length, String value) {
		super();
		this.type = type;
		this.length = length;
		this.value = value;
	}

	public TLV(Type type, Integer length, String value, Boolean isValid) {
		super();
		this.type = type;
		this.length = length;
		this.value = value;
		this.isValid = isValid;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "TLV [type=" + type + ", length=" + length + ", value=" + value + ", isValid=" + isValid + "]";
	}
	
}
