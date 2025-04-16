package unit03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet03")
public class HelloServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");  //평문
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>");
		out.println("Hello Servlet");
		out.println("헬로우 서블릿");
		out.println("</h1></body></html>");
		
		
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
