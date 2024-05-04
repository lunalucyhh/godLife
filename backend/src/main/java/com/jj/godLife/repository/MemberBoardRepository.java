package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.MemberBoard;

@Repository
public interface MemberBoardRepository extends JpaRepository<MemberBoard, Long>{
}
