package com.jj.godLife.exception;

import com.jj.godLife.constant.ErrorCode;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
    
}
