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
@Table(name = "t_member_user")
public class MemberUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_no")
    private Long userNo;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("login_type")
    private Integer loginType;

    @JsonProperty("ins_timestamp")
    private ZonedDateTime insTimestamp;

    @JsonProperty("upd_timestamp")
    private ZonedDateTime updTimestamp;

}
