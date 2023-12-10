package com.jj.godLife.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "t_reply")
public class Reply {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JsonProperty("reply_no")
    private Long replyNo;

    @JsonProperty("reply_contents")
    private String replyContents;

    @JsonProperty("reply_writer")
    private String replyWriter;

    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;

    @JsonProperty("ins_user")
    private String insUSer;

    @JsonProperty("del_timestamp")
    private ZonedDateTime delTimestamp;

    @JsonProperty("del_user")
    private String delUSer;
}
