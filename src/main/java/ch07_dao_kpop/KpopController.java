package ch07_dao_kpop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet({ "/ch07/kpop/list", "/ch07/kpop/insertArtist", "/ch07/kpop/updateArtist", "/ch07/kpop/deleteArtist",
		"/ch07/kpop/insertSong", "/ch07/kpop/updateSong", "/ch07/kpop/deleteSong", "/ch07/kpop/wrong" })
public class KpopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KpopDaoImpl kDao = new KpopDaoImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		String[] uri = requestUri.split("/");
		String action = uri[uri.length - 1];
		String method = request.getMethod();
		RequestDispatcher rd = null;
		String name = null, title = null, lyrics = null, debut=null;
		int sid = 0, aid = 0, hitSongId = 0;
		Song song = null;
		Artist artist = null;

		switch (action) {
		case "list":
			List<Kpop> list = kDao.getKpopList();
			rd = request.getRequestDispatcher("/ch07/kpop/list.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
			break;

		case "insertArtist":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch07/kpop/insertArtist.jsp");
				rd.forward(request, response);
			} else {
				name = request.getParameter("name");
				debut = request.getParameter("debut");
				hitSongId = Integer.parseInt(request.getParameter("hitSongId"));
				artist = new Artist(name, LocalDate.parse(debut), hitSongId);
				kDao.insertArtist(artist);

				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;

		case "insertSong":
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/ch07/kpop/insertSong.jsp");
				rd.forward(request, response);
			} else {
				title = request.getParameter("title");
				lyrics = request.getParameter("lyrics");

				song = new Song(title, lyrics);
				kDao.insertSong(song);

				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
//
		case "updateArtist":
			if (method.equals("GET")) {
				String aidCheck = request.getParameter("aid");
				aid = (aidCheck != null) ? Integer.parseInt(aidCheck) : 0;
				artist = kDao.getArtist(aid);
				rd = request.getRequestDispatcher("/ch07/kpop/updateArtist.jsp");
				request.setAttribute("artist", artist);
				rd.forward(request, response);
			} else {
				aid = Integer.parseInt(request.getParameter("aid"));
				name = request.getParameter("name");
				debut = request.getParameter("debut");
				hitSongId = Integer.parseInt(request.getParameter("hitSongId"));
				artist = new Artist(aid, name, LocalDate.parse(debut),hitSongId);
				
				kDao.updateArtist(artist);
				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
		case "updateSong":
			if (method.equals("GET")) {
				String sidCheck = request.getParameter("sid");
				sid = (sidCheck != null) ? Integer.parseInt(sidCheck) : 0;
				song = kDao.getSong(sid);
				rd = request.getRequestDispatcher("/ch07/kpop/updateSong.jsp");
				request.setAttribute("song", song);
				rd.forward(request, response);
			} else {
				sid = Integer.parseInt(request.getParameter("sid"));
				title = request.getParameter("title");
				lyrics = request.getParameter("lyrics");
				song = new Song(sid, title, lyrics);
				kDao.updateSong(song);
				response.sendRedirect("/jw/ch07/kpop/list");
			}
			break;
//
		case "deleteArtist":
			String aidCheck = request.getParameter("aid");
			aid = (aidCheck != null) ? Integer.parseInt(aidCheck) : 0;
			kDao.deleteArtist(aid);
			response.sendRedirect("/jw/ch07/kpop/list");
			break;

		case "deleteSong":
			String sidCheck = request.getParameter("sid");
			sid = (sidCheck != null) ? Integer.parseInt(sidCheck) : 0;
			kDao.deleteSong(sid);
			response.sendRedirect("/jw/ch07/kpop/list");
			break;
//
		default:
			rd = request.getRequestDispatcher("/ch07/kpop/alertMsg.jsp");
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("url", "/jw/ch07/kpop/list");
			rd.forward(request, response);
		}
	}

}