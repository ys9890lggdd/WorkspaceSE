package web;

import java.io.PrintWriter;

public class HelloServlet {
	public void service(PrintWriter out) {
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Hello Servlet!!!</h3><hr>");
		out.println("</body>");
		out.println("</html>");
	
	}
}
