package com.gyojincompany.board.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.gyojincompany.board.dao.BoardDao;

public class BWriteCommand implements BCommand{
	
	public void execute(Model model, HttpServletRequest request) {
		BoardDao boardDao = new BoardDao();
		boardDao.write(request.getParameter("bname"), request.getParameter("btitle"), request.getParameter("bcontent"));
	}
}
