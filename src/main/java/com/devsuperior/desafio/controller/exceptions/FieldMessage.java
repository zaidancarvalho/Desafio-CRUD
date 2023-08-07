package com.devsuperior.desafio.controller.exceptions;

public class FieldMessage {

	private String name;
	private String birthDate;

	public FieldMessage(String name, String birthDate) {
		super();
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birthDate;
	}
}
