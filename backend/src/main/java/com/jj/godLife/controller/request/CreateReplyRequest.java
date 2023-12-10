package com.jj.godLife.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class CreateReplyRequest {
    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("contents")
    private String contents;

    @JsonProperty("writer")
    private String writer;
}
