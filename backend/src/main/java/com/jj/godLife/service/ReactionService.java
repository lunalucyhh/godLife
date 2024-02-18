package com.jj.godLife.service;

import com.jj.godLife.constant.ErrorCode;
import com.jj.godLife.controller.request.CreateReactionRequest;
import com.jj.godLife.controller.response.ReactionTypeResponse;
import com.jj.godLife.domain.Reaction;
import com.jj.godLife.domain.ReactionMapping;
import com.jj.godLife.domain.ReactionMappingID;
import com.jj.godLife.exception.CustomException;
import com.jj.godLife.repository.ReactionMappingRepository;
import com.jj.godLife.repository.ReactionRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReactionService {

    private final ReactionRepository reactionRepository;
    private final ReactionMappingRepository reactionMappingRepository;

    /*
    public Reaction create(){

    }
    */

    public List<ReactionTypeResponse> findReactions() {

        List<Reaction> findReactions = reactionRepository.findAll();
        List<ReactionTypeResponse> reactionTypeResponse = new ArrayList();

        for (Reaction reaction : findReactions){
            ReactionTypeResponse type = new ReactionTypeResponse();
            type.setReactionType(reaction.getReactionType());
            type.setReactionTitle(reaction.getReactionTitle());
            reactionTypeResponse.add(type);
        }

        return reactionTypeResponse;
    }

    @Transactional
    public ReactionMapping create(CreateReactionRequest request) {
       
        ReactionMapping newReaction = new ReactionMapping();
        System.out.println(request);
        newReaction.setReactionType(request.getReactionType());
        newReaction.setPostNo(request.getPostNo());
        newReaction.setReplyNo(request.getReplyNo());
        newReaction.setInsTimestamp(ZonedDateTime.now());
        newReaction.setInsUser(request.getInsUser());
        
        reactionMappingRepository.save(newReaction);

        return newReaction;
    }

    @Transactional
    public void delete(String reactionType, Long postNo, Long replyNo, String insUser){
        ReactionMappingID reactionMappingID = new ReactionMappingID();
        reactionMappingID.setReactionType(reactionType);
        reactionMappingID.setPostNo(postNo);
        reactionMappingID.setReplyNo(replyNo);
        reactionMappingID.setInsUser(insUser);
        System.out.println(reactionMappingID);
        
        ReactionMapping mapping = null;
		if (postNo != null) {
            mapping = reactionMappingRepository.findByReactionTypeAndInsUserAndPostNo(reactionType, insUser, postNo).orElseThrow(() -> CustomException.builder().errorCode(ErrorCode.BAD_DELETE_REACTION_REQUEST).build());
        }

        if (replyNo != null) {
            mapping = reactionMappingRepository.findByReactionTypeAndInsUserAndReplyNo(reactionType, insUser, replyNo).orElseThrow(() -> CustomException.builder().errorCode(ErrorCode.BAD_DELETE_REACTION_REQUEST).build());    
        }

        // delete 
        mapping.setDelTimestamp(ZonedDateTime.now());
        reactionMappingRepository.save(mapping);
        
        // System.out.println(reactionMappingRepository.findById(reactionMappingID).get());
        // deleteReaction.setDelTimestamp(ZonedDateTime.now());
    }

    

 /*
 */
}
