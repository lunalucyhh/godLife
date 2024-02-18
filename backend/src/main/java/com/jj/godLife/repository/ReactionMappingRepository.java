package com.jj.godLife.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.ReactionMapping;


@Repository
public interface ReactionMappingRepository extends JpaRepository<ReactionMapping, Long>{
    
    ReactionMapping findByReactionTypeAndInsUserAndPostNo(@Param("reactionType") String reactionType, @Param("insUser")String insUser, @Param("postNo")Long postNo);

    ReactionMapping findByReactionTypeAndInsUserAndReplyNo(String reactionType, String insUser, Long replyNo);
}
