package com.jj.godLife.controller;

import com.jj.godLife.controller.request.CreateMemberRequest;
import com.jj.godLife.domain.MemberUser;
import com.jj.godLife.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/register")
    public ResponseEntity<MemberUser> create(@RequestBody CreateMemberRequest request){
        System.out.println("request = " + request);
        MemberUser createMemberUser = MemberService.create(request);
        return ResponseEntity.ok().body(createMemberUser);
    }
}
