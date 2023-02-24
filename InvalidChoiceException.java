package com.Customexception;

public class InvalidChoiceException  extends RuntimeException

{

	private String message;
	public InvalidChoiceException(String message){
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
