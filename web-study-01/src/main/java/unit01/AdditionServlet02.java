package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sub")
public class AdditionServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdditionServlet02() {
        super();
    }

    /*
     * <html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>30</h1>
</body>
</html>
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = 20;
		int num2 = 10;
		int add = num1-num2;
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Addition</title></head>");
		out.println("<body>");
		out.println(num1 + " - " +num2 + " = " + add);
		out.println("</body></html>");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost..............");
	}

}
