package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.ReactionMapping;

@Repository
public interface ReactionMappingRepository extends JpaRepository<ReactionMapping, Long>{
    
}
