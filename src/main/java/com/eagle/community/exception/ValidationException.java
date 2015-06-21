package com.eagle.community.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.eagle.community.api.ErrorResponse;
import com.eagle.community.api.ValidationError;


public class ValidationException extends BaseWebApplicationException {

	private final static int status = 400;
    private List<ValidationError> errors = new ArrayList<ValidationError>();

    
    public ValidationException() {
    	this("Validation Error");
    }

    public ValidationException(String message) {
    	super(status, message, "The data passed in the request was invalid. Please check and resubmit");
    }
    
    

    public ValidationException(Set<? extends ConstraintViolation<?>> violations) {
        this();
        for(ConstraintViolation<?> constraintViolation : violations) {
            ValidationError error = new ValidationError();
            error.setMessage(constraintViolation.getMessage());
            error.setPropertyName(constraintViolation.getPropertyPath().toString());
            error.setPropertyValue(constraintViolation.getInvalidValue() != null ? constraintViolation.getInvalidValue().toString() : null);
            errors.add(error);
        }
    }


    @Override
	public ErrorResponse getErrorResponse() {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(String.valueOf(status));
        response.setApplicationMessage(getDeveloperMessage());
        response.setConsumerMessage(getErrorMessage());
        response.setValidationErrors(errors);
        return response;
    }
}
