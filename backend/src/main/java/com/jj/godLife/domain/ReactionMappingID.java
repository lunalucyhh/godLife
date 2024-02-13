package com.jj.godLife.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReactionMappingID implements Serializable{

    @JsonProperty("reaction_type")
    private String reactionType;

    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("reply_no")
    private Long replyNo;

    @JsonProperty("ins_user")
    private String insUser; 

}
