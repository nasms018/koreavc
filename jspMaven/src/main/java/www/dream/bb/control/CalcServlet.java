package www.dream.bb.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServ
 */
@WebServlet(urlPatterns = {"/calc"})
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalcServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map asdasda = request.getParameterMap();
		response.setContentType("text/html; charset=utf-8"); //response header setting
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>할일 - 부트스트랩스타일, 동적 정보 생성과 삭제</title>"
				+ "</head>"
				+ "<body>"
				+ "연동테스트"
				+ "</body>"
				+ "</html>");
	}

}
