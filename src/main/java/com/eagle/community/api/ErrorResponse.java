package com.eagle.community.api;

//请求处理遇到异常返回的对象
import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {

    private String errorCode;
    private String consumerMessage;
    private String applicationMessage;
    private List<ValidationError> validationErrors = new ArrayList<ValidationError>();

    public ErrorResponse() {}

    public ErrorResponse(String errorCode, String consumerMessage, String applicationMessage) {
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

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
