package unit07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String gender = request.getParameter("gender");
		String mail = request.getParameter("chk_mail");
		String msg = request.getParameter("content");
		
		PrintWriter out = response.getWriter();
		
		out.println("성별 : " + gender);
		out.println("<br>");
		out.println("메일수신여부 : " + mail);
		out.println("<br>");
		out.println("가입인사 : " + msg);
		out.println("<br>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
