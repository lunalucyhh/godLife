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
@Table(name = "t_member_authentification")
public class MemberAuthentification {
    @Id 
    @JsonProperty("user_no")
    private Long userNo;

    @JsonProperty("gather_agree")
    private Integer gatherAgree;

    @JsonProperty("cell_phone")
    private String cellPhone;

    @JsonProperty("email")
    private String email;

    @JsonProperty("birtyday")
    private String birthday;

    @JsonProperty("sex")
    private Integer sex;

    @JsonProperty("auth_timestamp")
    private ZonedDateTime authTimestamp;

}
