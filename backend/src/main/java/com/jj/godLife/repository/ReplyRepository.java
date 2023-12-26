package com.jj.godLife.repository;

import com.jj.godLife.domain.Reply;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByPostNo(Long postNo, PageRequest paging);
}
