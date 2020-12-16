package com.cos.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
 
@Service
public class BoardService {
		
	@Autowired
	private BoardRepository boardrepository;
	
	@Transactional(readOnly = true) 
	public void 글쓰기(Board board, User user) { // title, content
		board.setCount(0);
		board.setUser(user);
		boardrepository.save(board);
	}	
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) {
		return boardrepository.findAll(pageable);
	}
	
	public Board 글상세보기(int id) {
		return boardrepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세 보기 실패 : 아이디를 찾을 수 없습니다."); 
				});
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardrepository.deleteById(id);
	}
}
