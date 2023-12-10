package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateReplyRequest;
import com.jj.godLife.domain.Reply;
import com.jj.godLife.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;


    public Reply create(CreateReplyRequest request){
        Reply newReply = new Reply();
        newReply.setPostNo(request.getPostNo());
        newReply.setReplyContents(request.getContents());
        newReply.setReplyWriter(request.getWriter());
        newReply.setInsTimestamp(ZonedDateTime.now());
        newReply.setInsUSer(request.getWriter());

        replyRepository.save(newReply);
        return newReply;
    }
    @Transactional
    public void delete(Long replyNo){
        Reply deleteReply = replyRepository.findById(replyNo).get();

        deleteReply.setDelTimestamp(ZonedDateTime.now());
    }


}
