package com.jj.godLife.constant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    BAD_DELETE_REACTION_REQUEST(HttpStatus.BAD_REQUEST, "존재하지 않는 반응입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),
    BAD_POST_REACTION_RQUEST(HttpStatus.BAD_REQUEST, "이미 작성된 반응입니다."), 
    BAD_DELETE_DUPLICATE_REQUEST(HttpStatus.BAD_REQUEST, "이미 삭제된 반응입니다.");

    private final HttpStatus httpStatus;
    private final String errorMessage;

}
