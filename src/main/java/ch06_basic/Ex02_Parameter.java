package ch06_basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// localhost:8080/jw/ch06/params?id=101&title=title
// localhost:8080/jw/ch06/params?id&title  				입력값이 null 이기 때문에 기본값 지정하지 않으면 null 출력
@WebServlet("/ch06/params")
public class Ex02_Parameter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id_=req.getParameter("id");
//		int id = Integer.parseInt(id_);  -> 이 방법을 사용하면 id가 공란으로 둘 수가 없음
		int id = 0; // 입력이 되지 않았을 때 id의 기본값
		if (id_ != null && !id_.equals(""))
			id=Integer.parseInt(id_);
		
		String title = req.getParameter("title");
		System.out.println("GET id: " + id + ", title: " + title);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id_=req.getParameter("id");
		int id = 0; 
		if (id_ != null && !id_.equals(""))
			id=Integer.parseInt(id_);
		
		String title = req.getParameter("title");
		System.out.println("POST id: " + id + ", title: " + title);	
	}
}
// title에 값을 넣지 않으면 아무 값이 나오지 않음(null은 아님), 한글값도 가능