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
@Table(name = "t_reaction")
public class Reaction {
    @Id
    @JsonProperty("reaction_type")
    private String reactionType;

    @JsonProperty("reaction_title")
    private String reactionTitle;

    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;

    @JsonProperty("ins_user")
    private String insUser;

    @JsonProperty("del_timestamp")
    private ZonedDateTime delTimestamp;

    @JsonProperty("del_user")
    private String delUser;

}
