package com.inc.gtc.fire.err;

public class ProcessException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProcessException(String message)
	{
		super(message);
	}
	
	public ProcessException(Exception e)
	{
		super(e.getMessage());
	}
	
}