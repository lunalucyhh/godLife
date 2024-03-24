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
@Table(name = "t_auth_password")
public class AuthPassword {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("password_id")
    private Long passwordId;

    @JsonProperty("user_no")
    private Long userNo;

    @JsonProperty("salt")
    private String salt;

    @JsonProperty("user_password")
    private String userPassword;

    @JsonProperty("upd_timestamp")
    private ZonedDateTime updTimestamp;
    

}
