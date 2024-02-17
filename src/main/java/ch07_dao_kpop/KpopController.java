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
		"/ch07/kpop/insertSong", "/ch07/kpop/updateSong", "/ch07/kpop/deleteSong", "/ch07/kpop/wrong"})
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
				int sid = 0, aid = 0, hit_song_id = 0;
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
				hit_song_id = Integer.parseInt(request.getParameter("hit_song_id"));
				artist = new Artist(name, LocalDate.parse(debut), hit_song_id);
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
//			if (method.equals("GET")) {
//				id = Integer.parseInt(request.getParameter("id"));
//				city = cDao.getCity(id);
//				rd = request.getRequestDispatcher("/ch07/kpop/update.jsp");
//				request.setAttribute("city", city);
//				request.setAttribute("districts", districts);
//				rd.forward(request, response);
//			} else {
//				id = Integer.parseInt(request.getParameter("id"));
//				name = request.getParameter("name");
//				countryCode = request.getParameter("countryCode");
//				district = request.getParameter("district");
//				population_ = request.getParameter("population");
//				population = (population_.equals("")) ? 0 : Integer.parseInt(population_);
//				city = new City(id, name, countryCode, district, population);
//				cDao.updateCity(city);
//				response.sendRedirect("/jw/ch07/kpop/list?district=" + district + "&num=30&offset=0");
//			}
//			break;
		case "updateSong":
//			if (method.equals("GET")) {
//				id = Integer.parseInt(request.getParameter("id"));
//				city = cDao.getCity(id);
//				rd = request.getRequestDispatcher("/ch07/kpop/update.jsp");
//				request.setAttribute("city", city);
//				request.setAttribute("districts", districts);
//				rd.forward(request, response);
//			} else {
//				id = Integer.parseInt(request.getParameter("id"));
//				name = request.getParameter("name");
//				countryCode = request.getParameter("countryCode");
//				district = request.getParameter("district");
//				population_ = request.getParameter("population");
//				population = (population_.equals("")) ? 0 : Integer.parseInt(population_);
//				city = new City(id, name, countryCode, district, population);
//				cDao.updateCity(city);
//				response.sendRedirect("/jw/ch07/kpop/list?district=" + district + "&num=30&offset=0");
//			}
//			break;
//
		case "deleteArtist":
//			id = Integer.parseInt(request.getParameter("id"));
//			cDao.deleteCity(id);
//			response.sendRedirect("/jw/ch07/kpop/list?&num=30&offset=0");
//			break;

		case "deleteSong":
//			id = Integer.parseInt(request.getParameter("id"));
//			cDao.deleteCity(id);
//			response.sendRedirect("/jw/ch07/kpop/list?&num=30&offset=0");
//			break;
//
		default:
//			rd = request.getRequestDispatcher("/ch07/kpop/alertMsg.jsp");
//			request.setAttribute("msg", "잘못된 접근입니다.");
//			request.setAttribute("url", "/jw/ch07/kpop/list");
//			rd.forward(request, response);
		}
	}
}