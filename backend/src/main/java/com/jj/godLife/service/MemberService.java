package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateMemberRequest;
import com.jj.godLife.domain.MemberAuthentification;
import com.jj.godLife.domain.MemberUser;
import com.jj.godLife.repository.AuthCidiRepository;
import com.jj.godLife.repository.AuthPasswordRepository;
import com.jj.godLife.repository.AuthSocialLoginRepository;
import com.jj.godLife.repository.MemberAuthentificationRepository;
import com.jj.godLife.repository.MemberUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.ZonedDateTime;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberUserRepository memberUserRepository;
    private final MemberAuthentificationRepository memberAuthentificationRepository;
    private final AuthCidiRepository AUthcidi;
    private final AuthSocialLoginRepository AuthSocialLogin;
    private final AuthPasswordRepository authPassword;
    private final 

    public MemberUser create(CreateMemberRequest request) {
        
        MemberUser newUser = new MemberUser();
        System.out.println(request);
        newUser.setUserName(request.getUserName());
        newUser.setLoginType(request.getLoginType());
        newUser.setInsTimestamp(ZonedDateTime.now());

        memberUserRepository.save(newUser);

    
        return newUser;
    }

    public MemberAuthentification memberCreate(CreateMemberRequest request) {

        MemberAuthentification newMember = new MemberAuthentification();
        newMember.setUserNo(getUserNo());
        newMember.setGatherAgree(request.getGatherAgree());
        newMember.setCellPhone(request.getCellPhone());
        newMember.setEmail(request.getEmail());
        newMember.setBirthday(request.getBirthday());
        newMember.setSex(request.getSex());

        memberAuthentificationRepository.save(newMember);
        return newMember;
    }
 
   

}
