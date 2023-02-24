package com.Customexception;

public class StudentIdNotFound  extends Exception
{

	private String message;
	public StudentIdNotFound(String message){
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
