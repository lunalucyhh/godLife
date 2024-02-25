package com.jj.godLife.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;


@Setter
public class PostNoReactionResponse {
    
    @JsonProperty("reaction_type")
    private String reactionType;
    
    @JsonProperty("total_count")
    private Long totalCount;

}
