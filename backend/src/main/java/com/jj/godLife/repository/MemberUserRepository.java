package com.jj.godLife.repository;

import com.jj.godLife.domain.MemberUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberUserRepository extends JpaRepository<MemberUser, Long> {
}
