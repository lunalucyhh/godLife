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
@Table(name = "t_royalty_history")
public class RoyaltyHistory {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @JsonProperty("history_id")
   private Long historyId;

   @JsonProperty("user_no")
   private Long userNo;

   @JsonProperty("increase_royalty")
   private Long increaseRoyalty;

   @JsonProperty("ins_timestamp")
   private ZonedDateTime insTimestamp;
   
}
