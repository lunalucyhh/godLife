package com.jj.godLife.controller.response;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Setter;

@Setter
public class ReplyResponse {
    @JsonProperty("reply_no")
    private Long replyNo;

    @JsonProperty("reply_contents")
    private String replyContents;

    @JsonProperty("reply_writer")
    private String replyWriter;
    
    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;
}
