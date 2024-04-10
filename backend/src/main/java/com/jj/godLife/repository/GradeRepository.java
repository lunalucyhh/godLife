package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{

}
