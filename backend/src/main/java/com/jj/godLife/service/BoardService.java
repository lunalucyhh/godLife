package com.jj.godLife.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jj.godLife.domain.Board;
import com.jj.godLife.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	private final BoardRepository boardRepository;

	public List<Board> getBoardList() {
		return boardRepository.findAll();
	}
}
