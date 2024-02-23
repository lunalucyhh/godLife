package com.jj.godLife.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.jj.godLife.domain.ReactionMapping;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
public class PostNoReactionResponse extends ReactionMapping {
    
    @JsonProperty("reaction_type")
    private String reactionType;
    
    @JsonProperty("total_count")
    private Long totalCount;

}
