package com.work.myretail.exception;

public class MyRetailException extends Exception{
	private static final long serialVersionUID = 327252321959100621L;

	public MyRetailException(Throwable e){
		super(e);
	}
	
	public MyRetailException(String message, Throwable th ){
		super(message,th);
	}

	public MyRetailException(String string) {
		super(string);
	}
	
	public MyRetailException(String message,Exception e){
		super(message,e);
	}
}
