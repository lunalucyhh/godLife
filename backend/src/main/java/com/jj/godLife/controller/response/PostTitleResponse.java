package com.jj.godLife.controller.response;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class PostTitleResponse {
    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("post_title")
    private String postTitle;

    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;

}
