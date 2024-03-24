package com.jj.godLife.domain;

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
@Table(name = "t_auth_cidi")
public class AuthCidi {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("cidi_id")
    private Long cidiId;

    @JsonProperty("user_no")
    private Long userNo;

    @JsonProperty("ci")
    private String ci;

    @JsonProperty("di")
    private String di;
}
