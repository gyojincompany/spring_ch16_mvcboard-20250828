package com.gyojincompany.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gyojincompany.board.dao.BoardDao;
import com.gyojincompany.board.dto.BoardDto;

public class BContentViewCommand implements BCommand {

	@Override
	public void execute(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String bnum = request.getParameter("bnum"); //유저가 클릭한 글의 번호
		BoardDao boardDao = new BoardDao();
		BoardDto bDto = boardDao.contentView(bnum);
		
		model.addAttribute("bDto", bDto);

	}

}
