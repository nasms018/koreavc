package www.dream.bb.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServ
 */
@WebServlet(urlPatterns = {"/hello1"})
public class MyServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); //response header setting
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>할일 - 부트스트랩스타일, 동적 정보 생성과 삭제</title>"
				+ "</head>"
				+ "<body>"
				+ ""
				+ "</body>"
				+ "</html>");
	}

}
