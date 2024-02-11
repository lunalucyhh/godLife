package com.jj.godLife.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "t_reaction_mapping")
public class ReactionMapping {
    

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JsonProperty("mapping_no")
    private Long mappingNo;

    @JsonProperty("reaction_type")
    private String reactionType;

    @JsonProperty("post_no")
    private Long postNo;

    @JsonProperty("reply_no")
    private Long replyNo;

    @JsonProperty("ins_user")
    private String insUser;
    
    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;
    
    @JsonProperty("del_timestamp")
    private ZonedDateTime delTimestamp;

    @JsonProperty("del_user")
    private String delUser;


}
