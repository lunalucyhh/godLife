package com.jj.godLife.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(ReactionMappingID.class)
public class ReactionMapping implements Serializable {
    

    @Id 
    @JsonProperty("reaction_type")
    private String reactionType;

    @Id
    @JsonProperty("post_no")
    private Long postNo;

    @Id
    @JsonProperty("reply_no")
    private Long replyNo;

    @Id
    @JsonProperty("ins_user")
    private String insUser;
    
    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;
    
    @JsonProperty("del_timestamp")
    private ZonedDateTime delTimestamp;

    @JsonProperty("del_user")
    private String delUser;


}
