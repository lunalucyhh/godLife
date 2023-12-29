package com.jj.godLife.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Setter
public class ReactionTypeResponse {
    @JsonProperty("reaction_no")
    private Long reactionNo;

    @JsonProperty("reaction_title")
    private String reactionTitle;

    @JsonProperty("reaction_type")
    private String reactionType;

}
