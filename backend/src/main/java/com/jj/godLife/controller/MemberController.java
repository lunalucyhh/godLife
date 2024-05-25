package com.jj.godLife.controller;

import com.jj.godLife.controller.request.CreateMemberRequest;
import com.jj.godLife.domain.MemberUser;
import com.jj.godLife.service.MemberService;
import com.jj.godLife.validator.MemberValidator;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;
    private final MemberValidator memberValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberValidator);
    }
    @PostMapping("/register")
    public ResponseEntity<MemberUser> create(@Validated @RequestBody CreateMemberRequest request,  BindingResult bindingResult){
        System.out.println("request = " + request);
        MemberUser createMemberUser = memberService.create(request);

        if(bindingResult.hasErrors()) {
           bindingResult.getFieldErrors();
           System.out.println(bindingResult.getFieldErrors());
        }

        return ResponseEntity.ok().body(createMemberUser);
    }
}
