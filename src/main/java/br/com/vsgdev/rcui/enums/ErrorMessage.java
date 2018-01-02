package br.com.vsgdev.rcui.enums;

public enum ErrorMessage {

	ENTITY_NOT_FOUND("Entity not found with the id: %s"),
	MANDATORY_FIELDS_MISSING("The mandatory fields: %s are missing");

	private String message;

	private ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
