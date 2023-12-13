package com.kh.springdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser,Long>{

	// 로그인을 하기 위해 검색하는 코드를 작성해줄 예정
	// Optional 을 사용할지 .orElse(null); 를 사용할지 자유
	Optional<SiteUser> findByUserName(String username);
}
