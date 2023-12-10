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
@Table(name = "t_post")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("post_title")
    private String postTitle;

    @JsonProperty("post_contents")
    private String postContents;

    @JsonProperty("post_writer")
    private String postWriter;

    @JsonProperty("board_no")
    private Long boardNo;

    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;

    @JsonProperty("ins_user")
    private String insUser;

    @JsonProperty("upd_timestamp")
    private ZonedDateTime updTimestamp;

    @JsonProperty("upd_user")
    private String updUser;

    @JsonProperty("del_timestamp")
    private ZonedDateTime delTimestamp;

    @JsonProperty("del_user")
    private String delUser;

    
}
