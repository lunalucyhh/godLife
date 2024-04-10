package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.MemberAuthentification;

@Repository
public interface MemberAuthentificationRepository extends JpaRepository<MemberAuthentification, Long> {

}
