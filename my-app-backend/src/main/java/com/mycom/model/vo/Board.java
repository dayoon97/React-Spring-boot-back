package com.mycom.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Data
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;
	
	private String boardName;
	private String boardRegDate;
	private String boardWriter;
	private String boardContent;
	
	
	@Builder
	public Board(String boardName, String boardRegDate, String boardWriter, String boardContent) {
		super();
		this.boardName = boardName;
		this.boardRegDate = boardRegDate;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
	}

	
}
