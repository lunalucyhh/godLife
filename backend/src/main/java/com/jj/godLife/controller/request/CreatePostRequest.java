package com.jj.godLife.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class CreatePostRequest {
    @JsonProperty("board_no")//들어옴
    private Long boardNo;//받음

    @JsonProperty("title")
    private String title;

    @JsonProperty("contents")
    private String contents;
}
