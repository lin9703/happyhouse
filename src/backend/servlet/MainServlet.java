package backend.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.dto.User;
import backend.model.service.UserServiceImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String root;

	// method = "post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	// method = "get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		root = request.getContextPath();
		String act = request.getParameter("act");
		try {
			if (act == null) {
				response.sendRedirect(root + "/index.jsp");
			} else if (act.equals("login")) {
				login(request, response);
			} else if (act.equals("logout")) {
				logout(request, response);
			}
		} catch (SQLException e) {
		}
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		User user = UserServiceImpl.getUserService().login(id, password);
		
		//String nowPath = request.getRequestURL().toString();
		String path = "/index.jsp";
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", user);
			response.sendRedirect(root + path);
		} else {
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요.");
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		session.invalidate();

		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
