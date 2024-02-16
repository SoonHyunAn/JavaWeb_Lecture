package ch07_dao_kpop;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class KpopDaoImpl implements KpopDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/" + "jdbc/world");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public List<Kpop> getKpopList() {
		Connection conn = getConnection();
		String sql = "select girl_group.gid No, girl_group.name 그룹명, girl_group.debut 데뷔일, song.title 제목, song.lyrics 가사 from girl_group JOIN song ON girl_group.hit_song_id=song.sid";
		List<Kpop> list = new ArrayList<Kpop>();
		Kpop kpop = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				kpop = new Kpop(rs.getInt(1), rs.getString(2), LocalDate.parse(rs.getString(3)), rs.getString(4),
						rs.getString(5));
				list.add(kpop);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Artist> getArtistList() {
		Connection conn = getConnection();
		String sql = "select * from girl_group";
		List<Artist> list = new ArrayList<Artist>();
		Artist girl_group = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				girl_group = new Artist(rs.getInt(1), rs.getString(2), LocalDate.parse(rs.getString(3)));
				list.add(girl_group);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Song> getSongList() {
		Connection conn = getConnection();
		String sql = "select * from song";
		List<Song> list = new ArrayList<Song>();
		Song song = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(song);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Artist getArtist(int aid) {
		Connection conn = getConnection();
		String sql = "select * from girl_group where gid =?";
		Artist artist = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				artist = new Artist(rs.getInt(1), rs.getString(2), LocalDate.parse(rs.getString(3)));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public Song getSong(int sid) {
		Connection conn = getConnection();
		String sql = "select * from song where sid =?";
		Song song = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return song;
	}

	@Override
	public void insertArtist(Artist artist) {
		Connection conn = getConnection();
		String sql = "insert into girl_group values (default,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, artist.getName());
			pstmt.setString(2, artist.getDebut().toString());
			pstmt.setInt(3, artist.getHitSongId());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateArtist(Artist artist) {
		Connection conn = getConnection();
		String sql = "update girl_group set name = ?, debut= ? where gid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, artist.getName());
			pstmt.setString(2, artist.getDebut().toString());
			pstmt.setInt(3, artist.getAid());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertSong(Song song) {
		Connection conn = getConnection();
		String sql = "insert into song values (default,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyrics());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSong(Song song) {
		Connection conn = getConnection();
		String sql = "update song set title = ?, lyrics= ? where sid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, song.getTitle());
			pstmt.setString(2, song.getLyrics());
			pstmt.setInt(3, song.getSid());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArtist(int aid) {
		Connection conn = getConnection();
		String sql = "delete from girl_group where gid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSong(int sid) {
		Connection conn = getConnection();
		String sql = "delete from song where sid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
