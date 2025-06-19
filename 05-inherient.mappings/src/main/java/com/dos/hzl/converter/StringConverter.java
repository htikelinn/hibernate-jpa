package com.dos.hzl.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class StringConverter implements AttributeConverter<String, Integer>{

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		return Integer.parseInt(attribute);
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		return dbData.toString();
	}

}
