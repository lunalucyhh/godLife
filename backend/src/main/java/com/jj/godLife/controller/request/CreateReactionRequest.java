package com.jj.godLife.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class CreateReactionRequest {
    @JsonProperty("reaction_type")
    private String reactionType;

    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("reply_no")
    private Long replyNo;

    @JsonProperty("ins_user")
    private String insUser;    

    
}
