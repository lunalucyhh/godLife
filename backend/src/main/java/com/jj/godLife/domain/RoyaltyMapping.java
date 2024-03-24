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
@Table(name = "t_royalty_mapping")
public class RoyaltyMapping {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("mapping_no")
    private Long mappingNo;

    @JsonProperty("user_no")
    private Long userNo;

    @JsonProperty("royalty_total")
    private Long royaltyTotal;

    @JsonProperty("upd_timestamp")
    private ZonedDateTime updTimestamp;

    @JsonProperty("grade_no")
    private Long gradeNo;
}
