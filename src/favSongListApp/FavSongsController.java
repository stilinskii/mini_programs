package favSongListApp;

import java.util.HashMap;
import java.util.List;

public class FavSongsController {
	private FavSongsDAO daoModel;
	private FavSongsView view;
	

	public FavSongsController(FavSongsDAO daoModel,FavSongsView view) {
		this.daoModel = daoModel;
		this.view = view;
	}
	
	// create
	public void createFavSongsProcess() {
		 daoModel.createFavSongs();
	}
	

	// search
	public void searchFavSongsProcess(String title) {
		// 이건 테이블을 업데이트 한 것이 아니라서 직접 값을 넣어줘야함. 아님 리턴하던가
		new FavSongsView().prn(daoModel.searchFavSongs(title));
	}

	// insert
	public void insertFavSongsProcess(FavSongsDTO dto) {
		
		int chk = daoModel.insertFavSongs(dto);
		System.out.printf("%d개 레코드 삽입 완료\n",chk);
		updateView();
		
	}

	// update
	public void updateFavSongsProcess(String title,int column,String editVal) {
		daoModel.updateFavSongs(title, column, editVal);
		updateView();
	}

	// delete
	public void deleteFavSongsProcess(String title) {
		int chk = daoModel.deleteFavSongs(title);
		System.out.printf("%d개 레코드 삭제 완료\n",chk);
		updateView();

	}
	
	//list
	public void updateView()
    {                
        view.prn(daoModel.listFavSongs());
    }

}
