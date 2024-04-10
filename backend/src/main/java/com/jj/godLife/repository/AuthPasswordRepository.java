package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.AuthPassword;

@Repository
public interface AuthPasswordRepository extends JpaRepository<AuthPassword, Long> {

}
