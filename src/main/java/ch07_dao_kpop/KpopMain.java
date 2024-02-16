package ch07_dao_kpop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class KpopMain {

	public static void main(String[] args) {
		KpopDaoImpl kDaoImpl = new KpopDaoImpl();
		Artist artist = new Artist(); 
		Song song = new Song();
		List<Kpop> listMain = new ArrayList<Kpop>();
		List<Artist> listArtist = kDaoImpl.getArtistList();
		List<Song> listSong = kDaoImpl.getSongList();
		
		//1번
//		listMain = kDaoImpl.getKpopList();
//		listMain.forEach(x->System.out.println(x));
//		System.out.println();
//		
		//2번
//		artist = kDaoImpl.getArtist(1001);
//		System.out.println(artist);
		
		//3번
//		song = kDaoImpl.getSong(101);
//		System.out.println(song);
		
//		//4번
//		artist= new Artist("블랙핑크", LocalDate.parse("2016-08-08"));
//		kDaoImpl.insertArtist(artist);
//		listArtist.forEach(x->System.out.println(x));
//		System.out.println();
//		
//		//5번
//		song= new Song("붐바야", "붐바야붐바야");
//		kDaoImpl.insertSong(song);
//		listSong.forEach(x->System.out.println(x));
//		System.out.println();

		//6번
//		artist = kDaoImpl.getArtist(1001);
//		artist.setName("WonderGirls");
//		artist.setDebut(LocalDate.parse("2007-02-11"));
//		kDaoImpl.updateArtist(artist);
//		listArtist.forEach(x->System.out.println(x));
		
		//7번
//		song = kDaoImpl.getSong(101);
//		song.setTitle("텔미");
//		song.setLyrics("테테레테레");
//		kDaoImpl.updateSong(song);
//		listSong.forEach(x->System.out.println(x));
		
		//8번, 9번
//		kDaoImpl.deleteArtist(1014);
//		kDaoImpl.deleteSong(118);
		
		kDaoImpl.close();
	}
}
