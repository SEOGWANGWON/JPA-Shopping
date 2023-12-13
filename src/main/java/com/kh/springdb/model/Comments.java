package com.kh.springdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Comments {
		   //Comment 였었음
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="comment_seq")
	@SequenceGenerator(name="comment_seq",
	sequenceName="comment_seq",
	allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	private String content;
	
	// 댓글에 좋아요를 누르고 싶다면 댓글 객체로 와서 추천에 관련된 필드를 설정해주면 됨
}
