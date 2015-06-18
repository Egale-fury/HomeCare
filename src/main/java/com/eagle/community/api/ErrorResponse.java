package com.eagle.community.api;

//请求处理遇到异常返回的对象
public class ErrorResponse {
	private String errorCode;
	private String consumerMessage;
	private String applicationMessage;
	
	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String errorCode, String consumerMessage,
			String applicationMessage) {
		super();
		this.errorCode = errorCode;
		this.consumerMessage = consumerMessage;
		this.applicationMessage = applicationMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getConsumerMessage() {
		return consumerMessage;
	}

	public void setConsumerMessage(String consumerMessage) {
		this.consumerMessage = consumerMessage;
	}

	public String getApplicationMessage() {
		return applicationMessage;
	}

	public void setApplicationMessage(String applicationMessage) {
		this.applicationMessage = applicationMessage;
	}
	
	

}
