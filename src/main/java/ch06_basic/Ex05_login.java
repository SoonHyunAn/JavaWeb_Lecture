package ch06_basic;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ch06/login")
public class Ex05_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// form을 제공해주는 역할
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ch06/loginForm.jsp");
		rd.forward(request, response);
	}

	// form을 처리해주는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		User user = new User();
		String url = "";
		user.setUid(uid);
		user.setPwd(pwd);
		
		RequestDispatcher rd = null;
		if (!uid.equals("james")) {
			user.setMessage("잘못된 아이디입니다.");
			user.setUrl("/jw/ch06/login");
			rd = request.getRequestDispatcher("/ch06/alertMsg.jsp");
		} else if (!pwd.equals("1234")) {
			user.setMessage("패스워드가 틀렸습니다.");
			user.setUrl("/jw/ch06/login");
			rd = request.getRequestDispatcher("/ch06/alertMsg.jsp");
		} else {
			user.setMessage("제임스님 환영합니다");
			user.setUrl("/jw/ch06/login");
			rd = request.getRequestDispatcher("/ch06/loginResult.jsp");	
		}
		request.setAttribute("user", user);
		rd.forward(request, response);
	}

}

// 그냥 setMessage로 사용하지 않고, String message를 형성해서 추가해주고 호출해도 된다. (from 강사님)
// 하지만 로그인 성공했을 때에도 alertMsg를 사용해야 하는 단점이 있다.

//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	String uid = request.getParameter("uid");
//	String pwd = request.getParameter("pwd");
//	
//	String msg, url;
//	if (!uid.equals("james")) {
//		msg = "잘못된 아이디입니다.";
//		url = "/jw/ch06/login";
//	} else if (!pwd.equals("1234")) {
//		msg = "패스워드가 틀렸습니다.";
//		url = "/jw/ch06/login";
//	} else {
//		msg = "제임스님 환영합니다.";
//		url = "/jw/ch06/loginResult.jsp";
//	}
//	RequestDispatcher rd = request.getRequestDispatcher("/ch06/alertMsg.jsp");
//	request.setAttribute("msg", msg);
//	request.setAttribute("url", url);
//	rd.forward(request, response);