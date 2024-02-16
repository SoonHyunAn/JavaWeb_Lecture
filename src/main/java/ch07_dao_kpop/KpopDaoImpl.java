package ch07_dao_kpop;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class KpopDaoImpl implements KpopDao {

	private String connStr;
	private String user;
	private String password;
	private Connection conn;

	public KpopDaoImpl() {
		String path = "C:/Workspace/WebProject/05. JAVA/Back_End_JAVA_Lecture/src/MySQL/sec05_basic/mysql.properties";
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));

			String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String database = prop.getProperty("database");

			this.connStr = "jdbc:mysql:/" + host + ":" + port + "/" + database;
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");
			this.conn = DriverManager.getConnection(connStr, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Kpop> getKpopList() {
		return null;
	}

	@Override
	public Artist getArtist(int aid) {
		return null;
	}

	@Override
	public Song getSong(int sid) {
		return null;
	}

	@Override
	public void insertArtist(Artist artist) {
	}

	@Override
	public void updateArtist(Artist artist) {
	}

	@Override
	public void insertSong(Artist artist) {
	}

	@Override
	public void updateSong(Artist artist) {
	}

	@Override
	public void deleteArtist(int aid) {
	}

	@Override
	public void deleteSong(int sid) {
	}

}
