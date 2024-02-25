package com.jj.godLife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.ReactionCount;
import com.jj.godLife.domain.ReactionMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public interface ReactionMappingRepository extends JpaRepository<ReactionMapping, Long>{
    
    ReactionMapping findByReactionTypeAndInsUserAndPostNo(@Param("reactionType") String reactionType, @Param("insUser")String insUser, @Param("postNo")Long postNo);
    ReactionMapping findByReactionTypeAndInsUserAndReplyNo(String reactionType, String insUser, Long replyNo);

    @Query(value = "select COUNT(reaction_type)" +
            "from t_reaction_mapping where post_no like concat('%',:postNo,'%') and reaction_type like concat('%',:reactionType,'%') group by reaction_type", nativeQuery = true)
    Long getCountByReactionTypeLikePostNo(@PathVariable("postNo") Long postNo, @Param("reactionType") String reactionType);

	/**
	 * [참고용 코드] Projecion 방법을 통해 Group By 절로 reaction_type 별 count 조회
	 * 
	 * @Query(value = "select new
	 *              com.jj.godLife.domain.ReactionCount(rm.reactionType, count(1))
	 *              from ReactionMapping as rm where rm.postNo = :postNo group by
	 *              rm.reactionType")
	 *              List<ReactionCount>
	 *              countByPostNoGroupByReactionType(@Param("postNo") Long postNo);
	 */

}
