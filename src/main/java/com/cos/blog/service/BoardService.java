package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardrepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다."); 
				}); // 영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수가 종료시(Service 가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹  자동으로 업데이트가 됨. DB  
	}
}
