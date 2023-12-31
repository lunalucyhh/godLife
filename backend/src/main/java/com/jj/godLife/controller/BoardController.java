package com.jj.godLife.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jj.godLife.domain.Board;
import com.jj.godLife.service.BoardService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService BoardService;

	@GetMapping
	public ResponseEntity<List<Board>> getBoardList() {

		return ResponseEntity.ok().body(BoardService.getBoardList());
	}
	
	
}
