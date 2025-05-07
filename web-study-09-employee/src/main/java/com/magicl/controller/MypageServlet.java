package com.magicl.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmployeesVO emp = (EmployeesVO) session.getAttribute("loginUser");
		if (emp != null) {
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();	
		
		EmployeesVO loginUser = (EmployeesVO) session.getAttribute("loginUser");

		EmployeesVO member = new EmployeesVO();
		member.setId(request.getParameter("id"));

		String pwd = request.getParameter("pwd");
		if (pwd != null && !pwd.trim().isEmpty()) {
			member.setPwd(pwd);
		} else {
			member.setPwd(loginUser.getPwd());
		}

		member.setName(request.getParameter("name"));
		member.setLev(request.getParameter("lev"));
		member.setGender(Integer.parseInt(request.getParameter("gender")));
		member.setPhone(request.getParameter("phone"));

		EmployeesDAO eDao = EmployeesDAO.getInstance();
		eDao.updateMember(member);

		EmployeesVO updated = eDao.getMember(member.getId());
		session.setAttribute("loginUser", updated);
		session.setAttribute("result", "A".equals(updated.getLev()) ? 0 : 1);

		request.setAttribute("member", updated);
		request.getRequestDispatcher("updatesuccess.jsp").forward(request, response);
	}
}
