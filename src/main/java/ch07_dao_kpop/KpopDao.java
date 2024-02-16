package ch07_dao_kpop;

import java.util.List;

public interface KpopDao {
		public List<Kpop> getKpopList();

		Artist getArtist(int aid) ;

		Song getSong(int sid) ;
		
		void insertArtist(Artist artist);

		void updateArtist(Artist artist);

		void insertSong(Artist artist) ;

		void updateSong(Artist artist);

		void deleteArtist(int aid);
		
		void deleteSong(int sid);

	}

}
