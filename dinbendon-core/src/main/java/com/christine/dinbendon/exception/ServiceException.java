package com.christine.dinbendon.exception;

/**
 * Christine 2019/11/28
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	public ServiceException() {
	}

	public ServiceException(String paramString) {
		super(paramString);
	}

	public ServiceException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public ServiceException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

}
