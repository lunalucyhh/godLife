package com.jj.godLife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jj.godLife.domain.AuthSocialLogin;

@Repository
public interface AuthSocialLoginRepository extends JpaRepository<AuthSocialLogin, Long> {

}
