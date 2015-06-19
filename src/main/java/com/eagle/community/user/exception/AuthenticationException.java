package com.eagle.community.user.exception;

import com.eagle.community.exception.BaseWebApplicationException;


public class AuthenticationException extends BaseWebApplicationException {

    public AuthenticationException() {
        super(401, "Authentication Error", "Authentication Error. The username or password were incorrect");
    }
}