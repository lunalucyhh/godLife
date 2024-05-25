package com.jj.godLife.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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
    @Column(name = "user_no", nullable = false)
    private Long userNo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "user_no")
    private MemberUser memberUser;

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
