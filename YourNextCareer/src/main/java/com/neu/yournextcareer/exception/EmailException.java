package com.neu.yournextcareer.exception;

public class EmailException extends Exception
{
	public EmailException(String message)
	{
		super(message);
	}
	
	public EmailException(String message, Throwable cause)
	{
		super(message,cause);
	}
}