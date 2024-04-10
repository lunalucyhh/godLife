package com.jj.godLife.service;

import com.jj.godLife.constant.ErrorCode;
import com.jj.godLife.controller.request.CreateReactionRequest;
import com.jj.godLife.controller.response.PostNoReactionResponse;
import com.jj.godLife.controller.response.ReactionTypeResponse;
import com.jj.godLife.domain.Reaction;
import com.jj.godLife.domain.ReactionMapping;
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
        
        ReactionMapping mapping = null;
		if (request.getPostNo() != null) {
            mapping = reactionMappingRepository.findByReactionTypeAndInsUserAndPostNo(request.getReactionType(), request.getInsUser(), request.getPostNo());
            if (mapping != null){
                throw CustomException.builder().errorCode(ErrorCode.BAD_POST_REACTION_RQUEST).build();        
            }
        };
        

        if (request.getReplyNo() != null) {
            mapping = reactionMappingRepository.findByReactionTypeAndInsUserAndReplyNo(request.getReactionType(), request.getInsUser(), request.getReplyNo());
            if (mapping != null){
                throw CustomException.builder().errorCode(ErrorCode.BAD_POST_REACTION_RQUEST).build();        
            }
        }

        reactionMappingRepository.save(newReaction);

        return newReaction;
    }

    @Transactional
    public void delete(String reactionType, Long postNo, Long replyNo, String insUser){
    
        ReactionMapping mapping = null;
		if (postNo != null) {
            mapping = reactionMappingRepository.findByReactionTypeAndInsUserAndPostNo(reactionType, insUser, postNo);
            if (mapping == null) {
               throw CustomException.builder().errorCode(ErrorCode.BAD_DELETE_REACTION_REQUEST).build();
            }
            if (mapping.getDelTimestamp() != null){
                throw CustomException.builder().errorCode(ErrorCode.BAD_DELETE_DUPLICATE_REQUEST).build();
            }
        }

        if (replyNo != null) {
            mapping = reactionMappingRepository.findByReactionTypeAndInsUserAndReplyNo(reactionType, insUser, replyNo);
            if (mapping == null) {
                throw CustomException.builder().errorCode(ErrorCode.BAD_DELETE_REACTION_REQUEST).build();
             }
            if (mapping.getDelTimestamp() != null){
                throw CustomException.builder().errorCode(ErrorCode.BAD_DELETE_DUPLICATE_REQUEST).build();
            }
        }

        // delete 
        mapping.setDelTimestamp(ZonedDateTime.now());
        reactionMappingRepository.save(mapping);
        
    
    }
    
    public List<PostNoReactionResponse> readReactions(Long postNo){
        List<Reaction> findReactions = reactionRepository.findAll();
        List<PostNoReactionResponse> postNoReactionResponse = new ArrayList<>();
        for (Reaction findReaction : findReactions) {
            PostNoReactionResponse reaction = new PostNoReactionResponse();
            reaction.setReactionType(findReaction.getReactionType());
            reaction.setTotalCount(reactionMappingRepository.getCountByReactionTypeLikePostNo(postNo, findReaction.getReactionType()));
            postNoReactionResponse.add(reaction);
        }


        return postNoReactionResponse;

    }

	/**
	 * [참고용 코드] Projecion 방법을 통해 Group By 절로 reaction_type 별 count 조회
	 * 
	 * public List<PostNoReactionResponse> readReactionsByProjection(Long postNo) {
	 * List<ReactionCount> reactionCountList =
	 * reactionMappingRepository.countByPostNoGroupByReactionType(postNo);
	 * return
	 * reactionCountList.stream().map(this::convertReactionCountResponse).collect(Collectors.toList());
	 * }
	 * 
	 * private PostNoReactionResponse convertReactionCountResponse(ReactionCount
	 * reactionCount) {
	 * PostNoReactionResponse postNoReactionResponse = new PostNoReactionResponse();
	 * postNoReactionResponse.setReactionType(reactionCount.getReactionType());
	 * postNoReactionResponse.setTotalCount(reactionCount.getCount());
	 * return postNoReactionResponse;
	 * 
	 * }
	 */

}
    

 /*
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
    List<ReactionMapping> readReactions = reactionMappingRepository.findAll();
        List<PostNoReactionResponse> postNoReactionResponse = new ArrayList<>();

        for (ReactionMapping reactionMapping: readReactions) {
            PostNoReactionResponse reaction = new PostNoReactionResponse();
            reaction.setReactionType(reactionMapping.getReactionType());
            reaction.setTotalCount(reactionMappingRepository.getCountByReactionType(postNo, reactionMapping.getReactionType()));
            postNoReactionResponse.add(reaction);
        }

 */

