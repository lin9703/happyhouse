package backend.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String root;
	// method = "get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		root = request.getContextPath();
		String act = request.getParameter("act");
		
		if(act == null) {
			response.sendRedirect(root+"/index.jsp");
		}else if(act.equals("login")) {
			
		}
		
	}

	// method = "post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
