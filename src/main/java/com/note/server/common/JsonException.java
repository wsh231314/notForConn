package com.note.server.common;

public class JsonException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String messageLocal;
	
	public JsonException(String message) {
		super();
		messageLocal = message;
	}

	@Override
	public String toString() {
		return "JsonException [messageLocal=" + messageLocal + "]";
	}
}
