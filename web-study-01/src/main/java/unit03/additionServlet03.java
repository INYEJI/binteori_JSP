package unit03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/additionServlet03")
public class additionServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public additionServlet03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
		
		request.setAttribute("n1", num1);
		request.setAttribute("n2", num2);
		request.setAttribute("add", add);
		
		RequestDispatcher dis = request.getRequestDispatcher("addition03.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}












