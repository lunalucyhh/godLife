package com.jj.godLife.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.godLife.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	List<Board> findAll();
}
