package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateReplyRequest;
import com.jj.godLife.controller.response.ReplyResponse;
import com.jj.godLife.domain.ReactionMapping;
import com.jj.godLife.domain.Reply;
import com.jj.godLife.repository.ReplyRepository;
import com.jj.godLife.repository.ReactionMappingRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    private final ReactionMappingRepository reactionMappingRepository;    
    
    public List<ReplyResponse> readReply(Long postNo, Integer page, Integer limit, String sort) {
        int offset = (page - 1) * limit;
        String[] array = sort.split("_");
        String dir = array[2].toUpperCase();
        String orderBy = String.format("%s%s", array[0], array[1]
                                        .substring(0, 1).toUpperCase() 
                                        + array[1].substring(1)); // insTimestamp
    
        PageRequest paging = PageRequest.of(offset, limit, Sort.by(Sort.Direction.valueOf(dir), orderBy));
        List<Reply> readReply = replyRepository.findAllByPostNo(postNo, paging);
        List<ReplyResponse> replyResponse = new ArrayList();
        for(Reply reply : readReply) {
            ReplyResponse replyRe = new ReplyResponse();
            replyRe.setReplyNo(reply.getReplyNo());
            replyRe.setReplyContents(reply.getReplyContents());
            replyRe.setReplyWriter(reply.getReplyWriter());
            replyRe.setInsTimestamp(reply.getInsTimestamp());
            replyResponse.add(replyRe);
        }
        return replyResponse;
    }

    
    
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
   


}
