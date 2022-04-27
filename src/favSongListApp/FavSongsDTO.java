package favSongListApp;

public class FavSongsDTO {
	private String title;
	private String singer;
	private int released;
	
	public FavSongsDTO() {
		// TODO Auto-generated constructor stub
	}

	public FavSongsDTO(String title, String singer, int released) {
		super();
		this.title = title;
		this.singer = singer;
		this.released = released;
	}
	
	
	@Override
	public String toString() {
		return String.format("%28s %35s %35s", title,singer,released);
	}

	
	
	
	//get set
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public int getReleased() {
		return released;
	}

	public void setReleased(int released) {
		this.released = released;
	}
	
	
	

}
