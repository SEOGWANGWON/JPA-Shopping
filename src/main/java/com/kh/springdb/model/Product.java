package com.kh.springdb.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="product_add_seq")
	@SequenceGenerator(name = "product_add_seq",
	sequenceName="product_add_seq",
	allocationSize=1)
	private int id;
	
	private String name;
	
	private String text;
	
	private String price;
	
	private int count;
	
	private int stock;
	
	private int isSoldout; // 상품 상태

	// 댓글 작성을 위한 Comment
	// @OneToMany(mappedBy="products", cascade=CascadeType.ALL)
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
	private List<Comments> comments;
	
	
	// 상품 이미지를 위한 필드 설정
	
	private String imgName; // 이미지 파일명
	
	private String imgPath; // 이미지 파일 조회 경로
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate createDate; // 상품 등록 날짜
	
	@PrePersist
	public void createDate() {
        this.createDate = LocalDate.now();
    }
	
	// 제품에 대한 좋아요를 받고 싶다면 여기에 추천과 관련된 변수를 넣어줘도 됨
	
	// 상품 좋아요 클릭해서 횟수 추가하기
	private int likes; 
	// 좋아요를 받는 방법은 여러 방법이 있음
	// 1. 사용자 관계없이 카운트만 올라가게하기
	// 2. ManyToOne 이나 OneToMany 이용해서 서로 카운트 주기
	
}
