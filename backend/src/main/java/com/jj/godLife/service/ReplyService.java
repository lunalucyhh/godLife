package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateReplyRequest;
import com.jj.godLife.domain.ReactionMapping;
import com.jj.godLife.domain.Reply;
import com.jj.godLife.repository.ReplyRepository;
import com.jj.godLife.repository.ReactionMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final ReactionMappingRepository reactionMappingRepository;    
    
    
    public Reply create(CreateReplyRequest request){
        Reply newReply = new Reply();

        newReply.setReplyContents(request.getContents());
        newReply.setReplyWriter(request.getWriter());
        newReply.setInsTimestamp(ZonedDateTime.now());
        newReply.setInsUser(request.getWriter());
        
        replyRepository.save(newReply);
        
        ReactionMapping newReactionMapping = new ReactionMapping();
        newReactionMapping.setReplyNo(newReply.getReplyNo());
        newReactionMapping.setPostNo(request.getPostNo());
    
        reactionMappingRepository.save(newReactionMapping);
        return newReply;
    }

    @Transactional
    public void delete(Long replyNo){
        Reply deleteReply = replyRepository.findById(replyNo).get();

        deleteReply.setDelTimestamp(ZonedDateTime.now());
    }

    public Reply readReply(Long postNo, Integer limit, Integer offset, String sort) {
        return null;
    }

    
   


}
