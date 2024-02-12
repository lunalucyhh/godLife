package com.jj.godLife.constant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_DELETE_REACTION_REQUEST(HttpStatus.BAD_REQUEST, "존재하지 않는 반응입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");

    private final HttpStatus httpStatus;
    private final String errorMessage;

}
