package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateMemberRequest;
import com.jj.godLife.domain.MemberUser;
import com.jj.godLife.repository.MemberUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberUserRepository memberUserRepository;

    public static MemberUser create(CreateMemberRequest request) {


        return MemberUser;
    }
}
