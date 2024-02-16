package ch07_dao_kpop;

import java.util.List;

public interface KpopDao {
	public List<Kpop> getKpopList();
	
	public List<Artist> getArtistList();
	
	public List<Song> getSongList();

	Artist getArtist(int aid);
	
	Song getSong(int sid);

	void insertArtist(Artist artist);

	void insertSong(Song song);

	void updateArtist(Artist artist);

	void updateSong(Song song);

	void deleteArtist(int aid);

	void deleteSong(int sid);
}