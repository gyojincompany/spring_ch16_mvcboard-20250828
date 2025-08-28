package com.gyojincompany.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
	
	private int bnum; //게시판 글번호
	private String btitle; //게시판 글제목
	private String bcontent; //게시판 글내용
	private String bname; //게시판 글쓴이
	private int bhit; //조회수
	private String bdate; //게시글 등록일

}
