package com.gyojincompany.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.board.command.BCommand;
import com.gyojincompany.board.command.BContentViewCommand;
import com.gyojincompany.board.command.BListCommand;
import com.gyojincompany.board.command.BWriteCommand;
import com.gyojincompany.board.dao.BoardDao;
import com.gyojincompany.board.dto.BoardDto;

@Controller
public class BoardController {
	
	BCommand command = null;
	
	@RequestMapping(value = "/write_form") //글쓰기 양식을 출력하는 요청 처리
	public String write_form() {
		return "writeForm";
	}
	
	@RequestMapping(value = "/write") //유저가 쓴 글을 DB에 삽입하는 요청 처리
	public String write(HttpServletRequest request, Model model) {		
		command = new BWriteCommand();
		command.execute(model, request);
		
		return "redirect:boardlist";
	}
	
	@RequestMapping(value = "/boardlist") //글 목록 보기 요청을 처리
	public String boardlist(HttpServletRequest request, Model model) {
		command = new BListCommand();
		command.execute(model, request);
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/content_view") //게시판 글 목록에서 내용 보고 싶은 글 제목을 클릭했을때의 요청 처리
	public String content_view(HttpServletRequest request, Model model) {
		
		command = new BContentViewCommand();
		command.execute(model, request);
		
		return "contentView";
	}
	
	
	
	
	

}
