package com.jj.godLife.exception;

import org.springframework.http.HttpStatus;

import com.jj.godLife.constant.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private final HttpStatus status;
    private final String errorMessage;

    public ErrorResponse(ErrorCode errorCode){
        this.status = errorCode.getHttpStatus();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
