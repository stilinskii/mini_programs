package favSongListApp;

import java.util.List;

public class FavSongsView {
	
	public void prn(List<FavSongsDTO> aList) {
		System.out.printf("%28s %35s %35s\n","SONG","SINGER","RELEASED");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		aList.forEach(e -> System.out.printf("%30s %30s %35d\n",
				e.getTitle(),e.getSinger(),e.getReleased()));
	}
	

	
}
