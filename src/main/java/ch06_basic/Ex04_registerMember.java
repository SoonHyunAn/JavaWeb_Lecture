package ch06_basic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ch06/register")
public class Ex04_registerMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// form을 제공해주는 역할
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ch06/registerForm.jsp");
		rd.forward(request, response);
	}

	// form을 처리해주는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		// uid 중복 확인. - Dao 활용
		// 패스워드 일치여부 파악. - equals
		// 입력된 값으로 User 객체 생성.
		// userService의 registerMember를 호출 (DB 등록)
		// 환영 메시지와 함께 로그인창으로 전환
		User user = new User(uid, pwd, name, email, LocalDate.now(), 0);
		RequestDispatcher rd = request.getRequestDispatcher("/ch06/registerResult.jsp");
		request.setAttribute("user", user);
		rd.forward(request, response);
	}

}
