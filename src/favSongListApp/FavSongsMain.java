package favSongListApp;

import java.util.Scanner;

public class FavSongsMain {
	static FavSongsController cont = new FavSongsController(FavSongsDAO.getInstance(), new FavSongsView());
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		label:while (true) {
			System.out.println();
			System.out.println("*-------*----------*----------*----------*----------*----------*----------*----------*----------*");
			System.out.println("   1. 노래 리스트 만들기 2. 노래 찾기 3. 노래 추가하기 4. 노래 정보 수정하기 5. 노래 삭제하기 6. 리스트 조회 7. 종료");
			System.out.println("*-------*----------*----------*----------*----------*----------*----------*----------*----------*");
			System.out.print("숫자를 입력해 주세요^^ : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
			case 1:
				createFavSongsList();
				break;
			case 2:
				searchFavSongsList();
				break;
			case 3:
				insertFavSongsList();
				break;
			case 4:
				updateFavSongsList();
				break;
			case 5:
				deleteFavSongsList();
				break;
			case 6:
				FavSongsList();
				break;
			case 7:
				System.out.println("종료");
				break label;
			}
		}

	}

	public static void createFavSongsList() {
		cont.createFavSongsProcess();

	}

	public static void searchFavSongsList() {
		System.out.print("노래 제목을 입력하세요 : ");
		cont.searchFavSongsProcess(sc.nextLine());
	}

	public static void insertFavSongsList() {
		System.out.print("노래제목 : ");
		String title = sc.nextLine();
		System.out.print("가수이름 : ");
		String singer = sc.nextLine();
		System.out.print("발매년도 : ");
		int released = sc.nextInt();
		sc.close();
		cont.insertFavSongsProcess(new FavSongsDTO(title, singer, released));

	}

	public static void updateFavSongsList() {
		System.out.print("1. title 2. singer 3. released");
		int column = sc.nextInt();
		sc.nextLine();
		System.out.print("바꿀정보 : ");
		String originVal = sc.nextLine();
		System.out.print("수정값 : ");
		String editVal = sc.nextLine();
		cont.updateFavSongsProcess(column,originVal,editVal);

	}

	public static void deleteFavSongsList() {

		System.out.print("삭제할 노래 제목을 입력하세요 : ");
		cont.deleteFavSongsProcess(sc.nextLine());

	}

	public static void FavSongsList() {

		cont.updateView();

	}


}
