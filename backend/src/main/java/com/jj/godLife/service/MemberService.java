package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateMemberRequest;
import com.jj.godLife.domain.AuthCidi;
import com.jj.godLife.domain.AuthPassword;
import com.jj.godLife.domain.Grade;
import com.jj.godLife.domain.MemberAuthentification;
import com.jj.godLife.domain.MemberBoard;
import com.jj.godLife.domain.MemberUser;
import com.jj.godLife.domain.RoyaltyHistory;
import com.jj.godLife.domain.RoyaltyMapping;
import com.jj.godLife.repository.AuthCidiRepository;
import com.jj.godLife.repository.AuthPasswordRepository;
import com.jj.godLife.repository.AuthSocialLoginRepository;
import com.jj.godLife.repository.GradeRepository;
import com.jj.godLife.repository.MemberAuthentificationRepository;
import com.jj.godLife.repository.MemberBoardRepository;
import com.jj.godLife.repository.MemberUserRepository;
import com.jj.godLife.repository.RoyaltyHistoryRepository;
import com.jj.godLife.repository.RoyaltymappingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.ZonedDateTime;


@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberUserRepository memberUserRepository;
    private final MemberAuthentificationRepository memberAuthentificationRepository;
    private final AuthCidiRepository authCidiRepository;
    private final AuthSocialLoginRepository authSocialLoginRepository;
    private final AuthPasswordRepository authPasswordRepository;
    private final MemberBoardRepository memberBoardRepository;
    private final GradeRepository gradeRepository;
    private final RoyaltymappingRepository royaltymappingRepository;
    private final RoyaltyHistoryRepository royaltyHistoryRepository;

    public MemberUser create(CreateMemberRequest request) {
        
        MemberUser newUser = new MemberUser();
        System.out.println(request);
        newUser.setUserName(request.getUserName());
        newUser.setLoginType(request.getLoginType());
        newUser.setInsTimestamp(ZonedDateTime.now());

        memberUserRepository.save(newUser);
        newUser.getUserNo();
        memberCreate(request);
        passwordCreate(request);
        cidiCreate(request);
        choiceBoard(request);
        royaltyCreate();
        return newUser;
    }



    public MemberAuthentification memberCreate(CreateMemberRequest request) {

        MemberAuthentification newMember = new MemberAuthentification();
        
        newMember.setGatherAgree(request.getGatherAgree());
        newMember.setCellPhone(request.getCellPhone());
        newMember.setEmail(request.getEmail());
        newMember.setBirthday(request.getBirthday());
        newMember.setSex(request.getSex());

        memberAuthentificationRepository.save(newMember);

        return newMember;
    }


    public AuthPassword passwordCreate(CreateMemberRequest request) {

        AuthPassword newPassword = new AuthPassword();
        newPassword.setUserPassword(request.getPassword());
        // newPassword.setSalt();
        newPassword.setUpdTimestamp(ZonedDateTime.now());

        authPasswordRepository.save(newPassword);
        return newPassword;
    }

    public AuthCidi cidiCreate(CreateMemberRequest request){
        AuthCidi newCidi = new AuthCidi();
        //newCidi.setCi(request.getCi);
        //newCidi.setDi(request.getDi);
        return newCidi;
    }

    private MemberBoard choiceBoard(CreateMemberRequest request) {
\       MemberBoard newMemberBoard = new MemberBoard();
        newMemberBoard.setUserNo(request.getUserNo());
        newMemberBoard.setBoardNo(request.getBoardNo());
        memberBoardRepository.save(newMemberBoard);

        return newMemberBoard; 
    }

    public RoyaltyMapping royaltyCreate(){
        RoyaltyMapping newRoyalty = new RoyaltyMapping();

        newRoyalty.setRoyaltyTotal(0L);
        newRoyalty.setUpdTimestamp(ZonedDateTime.now());

        royaltymappingRepository.save(newRoyalty);
        royaltyHistoryCreate();
        setMemberGrade();
        return newRoyalty;
    }

    
    public RoyaltyHistory royaltyHistoryCreate(){
        RoyaltyHistory newHistory = new RoyaltyHistory();

        newHistory.setIncreaseRoyalty(0L);
        newHistory.setInsTimestamp(ZonedDateTime.now());
        royaltyHistoryRepository.save(newHistory);
        
       return newHistory;
    }

    public Grade setMemberGrade(){
        Grade setDefaultGrade = new Grade();
        
        setDefaultGrade.setGradeNo(1L);
        gradeRepository.save(setDefaultGrade);
        return setDefaultGrade;
    }

    

    

}
