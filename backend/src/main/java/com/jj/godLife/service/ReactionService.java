package com.jj.godLife.service;

import com.jj.godLife.controller.response.ReactionTypeResponse;
import com.jj.godLife.domain.Reaction;
import com.jj.godLife.repository.ReactionRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReactionService {

    private final ReactionRepository reactionRepository;

    /*
    public Reaction create(){

    }
    */

    public List<ReactionTypeResponse> findReactions() {

        List<Reaction> findReactions = reactionRepository.findAll();
        List<ReactionTypeResponse> reactionTypeResponse = new ArrayList();

        for (Reaction reaction : findReactions){
            ReactionTypeResponse type = new ReactionTypeResponse();
            type.setReactionNo(reaction.getReactionNo());
            type.setReactionTitle(reaction.getReactionTitle());
            type.setReactionType(reaction.getReactionType());
            reactionTypeResponse.add(type);
        }

        return reactionTypeResponse;
    }
 /*
    public void delete(Long reactionNo){
        Reaction deleteReaction = reactionRepository.findById(reactionNo).get();
        deleteReaction.setDelTimestamp(ZonedDateTime.now());
    }

 */
}
