package com.mycom.model.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycom.model.vo.Board;

@Repository
public interface BoardRepository extends JpaRepository <Board, Long>{
		 List<Board> findByboardName(String boardName);
		 List<Board> findByboardRegDate(String boardRegDate);
		 List<Board> findByboardWriter(String boardWriter);
		 List<Board> findByboardContent(String boardContent);
}
