package com.eagle.community.exception;

import com.eagle.community.api.ErrorResponse;


public abstract  class BaseWebApplicationException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private int status = 400;
    private String errorMessage;
    private String developerMessage;
    

    public BaseWebApplicationException(int httpStatus, String errorMessage, String developerMessage) {
        this.status = httpStatus;
        this.errorMessage = errorMessage;
        this.developerMessage = developerMessage;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    public ErrorResponse getErrorResponse() {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(String.valueOf(status));
        response.setApplicationMessage(developerMessage);
        response.setConsumerMessage(errorMessage);
        return response;
    }

	public int getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}
    
}
