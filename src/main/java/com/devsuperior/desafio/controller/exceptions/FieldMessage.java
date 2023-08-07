package com.devsuperior.desafio.controller.exceptions;

public class FieldMessage {

	private String fieldName;
	private String message;

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getfieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}
}
