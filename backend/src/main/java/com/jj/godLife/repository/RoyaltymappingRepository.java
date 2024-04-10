package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.RoyaltyMapping;

@Repository
public interface RoyaltymappingRepository extends JpaRepository<RoyaltyMapping, Long> {

}
