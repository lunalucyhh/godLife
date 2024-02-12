package com.jj.godLife.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jj.godLife.constant.ErrorCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("null")
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleEmailDuplicateException(CustomException ex){
        log.error("handleEmailDuplicateException",ex);
        ErrorResponse response = new ErrorResponse(ex.getErrorCode().getHttpStatus(), ex.getErrorCode().getErrorMessage());
        return new ResponseEntity<>(response, ex.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        log.error("handleException",ex);
        ErrorResponse response = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus(), ErrorCode.INTERNAL_SERVER_ERROR.getErrorMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}