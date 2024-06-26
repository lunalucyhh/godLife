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
@Table(name = "t_auth_social_login")
public class AuthSocialLogin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("social_login_no")
    private Long socialLoginNo;

    @JsonProperty("user_no")
    private Long userNo;

    @JsonProperty("social_code")
    private Integer socialCode;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("upd_timestamp")
    private ZonedDateTime updTimestamp;
    
}
