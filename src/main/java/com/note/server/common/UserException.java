package com.note.server.common;

public class UserException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String messageLocal;
	
	public UserException(String message) {
		super();
		messageLocal = message;
	}

	@Override
	public String toString() {
		return "UserException [messageLocal=" + messageLocal + "]";
	}
}
