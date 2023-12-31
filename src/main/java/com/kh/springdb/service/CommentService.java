package com.kh.springdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.Comments;
import com.kh.springdb.model.Product;
import com.kh.springdb.repository.CommentRepository;
import com.kh.springdb.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	@Autowired
	private final CommentRepository commentRepository;
	
	@Autowired
	private final ProductRepository productRepository;
	
	// 댓글 추가 메서드 작성
	public Comments addComment(int productId, String content) {
		Product product = productRepository.findById(productId).orElse(null);
		// 만약에 상품이 존재하지 않을 경우 
		// 댓글 또한 존재하지 않으므로 
		// 댓글이 존재할 수 없음을 예외처리 함
		if(product == null) {
			throw new RuntimeException("찾는 상품은 존재하지 않습니다.");
		}
		// 댓글을 생성하기 위한 생성자 작성
		Comments comment = new Comments();
		comment.setProduct(product);
		comment.setContent(content);
		
		return commentRepository.save(comment);
		
	}
}
