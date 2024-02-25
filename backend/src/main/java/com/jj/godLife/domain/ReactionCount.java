package com.jj.godLife.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionCount {
	@JsonProperty("reaction_type")
	private String reactionType;
	private Long count;
}
