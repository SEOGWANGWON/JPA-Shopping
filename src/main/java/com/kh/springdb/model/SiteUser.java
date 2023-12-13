package com.kh.springdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="siteuser_seq")
	@SequenceGenerator(name="siteuser_seq",
	sequenceName="siteuser_seq",
	allocationSize=1)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private UserRole isRole;
	// private String isRole; // 방식의 차이 뭘 쓰던 상관없음
	

	@Column(unique = true)
	private String userName;
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	// 추천인을 넣고 싶다면 추천자를 생성해서 넣어도 됨
}
