package backend.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import backend.model.dao.DongCollectionImpl;
import backend.model.service.DongCollectionServiceImpl;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String root;

	// method = "get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		root = request.getContextPath();
		String act = request.getParameter("act");
		try {
		if(act == null) {
			response.sendRedirect(root+"/index.jsp");
		}else if(act.equals("gu")) {
			callGu(request, response);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	// method = "post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	// index, detail 페이지에서 "구"를 선택 시, 해당 구의 법정동을 보여줌
	protected void callGu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		// 1. 파라미터 확인
		String guName = request.getParameter("gu");

		// 2. 비즈니스 로직
		List<String> list = DongCollectionServiceImpl.getDongCollectionServiceImpl().getDongList(guName);
		// 참고!!. Json 문자열 <--> 자바 객체 (Gson 은 google에서 제공하는 jar 파일을 첨부해야함)
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		// 3. View 연결
		// Data만 보낼 때 아래와 같이 작성하면 된다.
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().append(json);
	}
}
