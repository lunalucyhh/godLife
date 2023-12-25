package com.jj.godLife.repository;

import com.jj.godLife.domain.Post;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findAllByBoardNo(Long boardNo, PageRequest paging);

}
