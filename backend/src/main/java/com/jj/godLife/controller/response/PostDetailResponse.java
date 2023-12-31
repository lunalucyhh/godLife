package com.jj.godLife.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;

import lombok.Setter;

@Setter
public class PostDetailResponse {
    @JsonProperty("post_title")
    private String postTitle;
    
    @JsonProperty("post_contents")
    private String postContents;

    @JsonProperty("post_writer")
    private String postWriter;

    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;

}
