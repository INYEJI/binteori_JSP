package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			
			MemberVO mVo  = (MemberVO)session.getAttribute("loginUser");
			
			MemberDAO mDao = MemberDAO.getInstance();
			mVo = mDao.getMember(mVo.getUserid());			
			
			session.setAttribute("loginUser", mVo);		
			url = "main.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		String url = "member/login.jsp";
		
		//DB연결해서 userid, pwd 해당 자가 있는지 확인!
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result =  mDao.userCheck(userid, pwd);
		/*
		switch(result) {
			case  1:
				System.out.println("로그인 여부 :  성공" );	
			break;
			case 0:
				System.out.println("로그인 여부 :  비번 틀림 ");
				break;
			case -1 : 
				System.out.println("로그인 여부 :  아이디 틀림 ");
				break;		
		}
		System.out.println("로그인 여부 :  " + result );
		*/
		
		if(result == 1) {
			
			MemberVO mVo = mDao.getMember(userid);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", mVo);			
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			
			url = "main.jsp";			
		}else if(result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");			
		}else if(result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response); 
	}

}
