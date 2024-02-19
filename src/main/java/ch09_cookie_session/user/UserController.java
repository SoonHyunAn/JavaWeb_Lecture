package ch09_cookie_session.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({ "/ch09/user/list", "/ch09/user/register", "/ch09/user/update", "/ch09/user/delete", "/ch09/user/login",
		"/ch09/user/logout" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService uSvc = new UserServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] uri = request.getRequestURI().split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		HttpSession session = request.getSession();

		RequestDispatcher rd = null;
		String uid = null, pwd = null, pwd2 = null, email = null, uname = null;
		String msg = null, url = null;
		User user = null;

		switch (action) {
		case "list": {
			String page_ = request.getParameter("page");
			int page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
			List<User> list = uSvc.getUserList(page);
			request.setAttribute("list", list);
			rd = request.getRequestDispatcher("/ch09/user/list.jsp");
			rd.forward(request, response);
			break;
		}
		case "register": {
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch09/user/register.jsp");
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				User result = uSvc.getUserByUid(uid);
				pwd = request.getParameter("pwd");
				pwd2 = request.getParameter("pwd2");
				uname = request.getParameter("uname");
				email = request.getParameter("email");
				result.setPwd(pwd); result.setEmail(email);
				result.setUid(uid); result.setUname(uname);
				if(!pwd.equals(pwd2)){
					msg = "비밀번호가 일치하지 않습니다.";
					url = "/ch09/user/register.jsp";
					rd = request.getRequestDispatcher("/ch09/user/alertMsg.jsp");
					request.setAttribute("msg", msg);
					request.setAttribute("url", url);
					rd.forward(request, response);
				}
				rd = request.getRequestDispatcher("/ch09/user/list.jsp");
				request.setAttribute("user", result);
				rd.forward(request, response);
			}
			break;
		}
		case "update": {
			break;
		}
		case "delete": {
			break;
		}
		case "login": {
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch09/user/login.jsp");
				rd.forward(request, response);
			} else {
				uid = request.getParameter("uid");
				pwd = request.getParameter("pwd");
				int result = uSvc.login(uid, pwd);
				if (result == uSvc.correct_login) {
					user = uSvc.getUserByUid(uid);
					session.setAttribute("sessUid", uid);
					session.setAttribute("sessUname", user.getUname());
					msg = user.getUname() + "님 환영합니다.";
					url = "/jw/ch09/user/list?page=1"; // 초기화면
				} else if (result == uSvc.WRONG_PASSWORD) {
					msg = "패스워드가 틀립니다.";
					url = "/jw/ch09/user/login";
				} else {
					msg = "등록되지 않은 사용자입니다.";
					url = "/jw/ch09/user/login";
				}
				rd = request.getRequestDispatcher("/ch09/user/alertMsg.jsp");
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				rd.forward(request, response);
			}
			break;
		}
		case "logout": {
			// session을 정리하면 된다.
			session.invalidate();
			response.sendRedirect("/jw/ch09/user/list?page=1");
			break;
		}

		}
	}
}
