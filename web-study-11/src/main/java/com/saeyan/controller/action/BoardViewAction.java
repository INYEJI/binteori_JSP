package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		//조회수 증가
		bDao.updateReadCount(num);
		
		//num(primary key)에 해당하는 전체 데이터를 가져오기
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);

		request.getRequestDispatcher("/board/boardView.jsp").forward(request, response);
	}

}
