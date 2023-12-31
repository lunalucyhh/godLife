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
@Table(name = "t_board")
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("board_no")
    private Long boardNo;

    @JsonProperty("board_title")
    private String boardTitle;

	
}
