package com.jj.godLife.service;

import com.jj.godLife.controller.request.CreateReactionRequest;
import com.jj.godLife.controller.response.ReactionTypeResponse;
import com.jj.godLife.domain.Post;
import com.jj.godLife.domain.Reaction;
import com.jj.godLife.domain.ReactionMapping;
import com.jj.godLife.repository.ReactionMappingRepository;
import com.jj.godLife.repository.ReactionRepository;
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

    public void delete(){
        Reaction deleteReaction = reactionMappingRepository.findById().get();
        deleteReaction.setDelTimestamp(ZonedDateTime.now());
    }

    

 /*
   

 */
}
