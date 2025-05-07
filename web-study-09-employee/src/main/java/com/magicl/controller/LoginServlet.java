//로그인 처리

package com.magicl.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url;

		EmployeesDAO empDAO = EmployeesDAO.getInstance();
		int result = empDAO.userCheck(id, pwd, lev);

		if (result == 1 || result == 0) {
			EmployeesVO emp = empDAO.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", emp);
			session.setAttribute("result", result); // 로그인한 사용자 유형 저장
			url = "main.jsp";
		} else {
			request.setAttribute("loginResult", result); // 오류 메시지 표시용
			url = "login.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
	}
}
