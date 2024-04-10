package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.AuthCidi;

@Repository
public interface AuthCidiRepository extends JpaRepository<AuthCidi, Long>{

}
