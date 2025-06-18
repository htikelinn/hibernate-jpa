package com.dos.hzl.entity.converters;

import jakarta.persistence.AttributeConverter;

public class StringConverter implements AttributeConverter<String, char[]> {

	@Override
	public char[] convertToDatabaseColumn(String attribute) {
		// TODO Auto-generated method stub
		return attribute.toCharArray();
	}

	@Override
	public String convertToEntityAttribute(char[] dbData) {
		// TODO Auto-generated method stub
		return dbData.toString();
	}

}
