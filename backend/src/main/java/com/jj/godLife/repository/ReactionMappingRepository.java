package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.ReactionMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public interface ReactionMappingRepository extends JpaRepository<ReactionMapping, Long>{
    
    ReactionMapping findByReactionTypeAndInsUserAndPostNo(@Param("reactionType") String reactionType, @Param("insUser")String insUser, @Param("postNo")Long postNo);
    ReactionMapping findByReactionTypeAndInsUserAndReplyNo(String reactionType, String insUser, Long replyNo);

    @Query(value = "select COUNT(reaction_type)" +
            "from t_reaction_mapping where post_no like concat('%',:postNo,'%') and reaction_type like concat('%',:reactionType,'%') group by reaction_type", nativeQuery = true)
    Long getCountByReactionTypeLikePostNo(@PathVariable("postNo") Long postNo, @Param("reactionType") String reactionType);


}
