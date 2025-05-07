package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVO bVo = new BoardVO();
		bVo.setNum(Integer.parseInt(num));
		bVo.setName(name);
		bVo.setEmail(email);
		bVo.setPass(pass);
		bVo.setTitle(title);
		bVo.setContent(content);
		
		BoardDAO.getInstance().updateBoard(bVo);
		
		//전체리스트목록이동
		new BoardListAction().execute(request, response);
		

	}

}
