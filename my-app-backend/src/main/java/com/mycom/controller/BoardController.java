package com.mycom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.model.service.BoardRepository;
import com.mycom.model.vo.Board;


@RestController
@EnableAutoConfiguration
public class BoardController {
	
	@Autowired
	BoardRepository boardRepository;
	
	public BoardController(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	@GetMapping("/api/board")
	public List<Board> getList(@RequestParam Map<String, String> param) {
		
//		String boardName = (String) param.get("boardName");
//		String boardRegDate = (String) param.get("boardRegDate");
//		String boardWriter = (String) param.get("boardWriter");
//		String boardContent = (String) param.get("boardContent");
//		
//		Board board = Board.builder()
//				.boardName(boardName)
//				.boardRegDate(boardRegDate)
//				.boardWriter(boardWriter)
//				.boardContent(boardContent)
//				.build();
//		boardRepository.save(board);
//		
		System.out.println(boardRepository.findAll());
//		
//		System.out.println("앙카ㅓㄴ오리ㅏ컨");
		
		
		
		return boardRepository.findAll();
		
	}
}
