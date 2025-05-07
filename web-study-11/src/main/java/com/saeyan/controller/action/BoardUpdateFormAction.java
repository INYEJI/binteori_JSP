package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String num = request.getParameter("num");
		
		BoardDAO bDao =BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(Integer.parseInt(num));
		
		request.setAttribute("board", bVo);
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);

	}

}
