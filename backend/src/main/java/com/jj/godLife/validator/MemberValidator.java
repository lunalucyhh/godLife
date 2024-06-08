package com.jj.godLife.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jj.godLife.controller.request.CreateMemberRequest;

@Component
public class MemberValidator implements Validator {
    /**
     * 검증하려는 클래스를 체크
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(CreateMemberRequest.class);
    }

    /**
     * 검증
     */
    @Override
    public void validate(Object target, Errors errors) {
        CreateMemberRequest createMemberRequest = (CreateMemberRequest) target;
        // 1. user_name 유효성 : 영어소문자 / 숫자 모두 포함, 6~16자
        String userName = createMemberRequest.getUserName();
        // 영어 소문자 / 숫자 체크 
        // 길이 체크 
        boolean result = Pattern.matches("^[a-z0-9]*.{6,16}$", userName);
        if(!result) {
            //에러 field와 에러 code를 입력
            errors.rejectValue("userName", "userName이 영소문자와 숫자 외의 문자가 포함되어있거나 길이가 맞지 않습니다.");
        }


        // 2. password 유효성 : 영어 대문자 / 영어 소문자 / 숫자 / 특수문자 모두 포함, 8~20자
        String password = createMemberRequest.getPassword();
        // 영어 대문자 / 영어 소문자 / 숫자 / 특수문자 체크
        // 길이체크
        result = Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,20}$", password);
        if(!result) {
            //에러 field와 에러 code를 입력
            errors.rejectValue("password", "password 기준에 적합하지 않습니다.");
        }

        // 3. boardNo 유효성
        Long boardNo = createMemberRequest.getBoardNo();
        boolean existsByBoardNo(boardNo);



    }


}