package com.jj.godLife.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class ReactionResponse {
    @JsonProperty("reaction_type")
    private String reactiontionType;
    
    
    private Long totalCount;
    
}
