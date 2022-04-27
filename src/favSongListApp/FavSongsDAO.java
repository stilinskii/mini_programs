package favSongListApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavSongsDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	private FavSongsDAO() {	}
	private static FavSongsDAO dao = new FavSongsDAO();
	public static FavSongsDAO getInstance() {
		return dao;
	}
	
	public Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		return DriverManager.getConnection(url,"hr","a1234");
		
	}
	
	
	public void exit() throws SQLException {
		if(rs != null) 
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(pstmt!=null)
			pstmt.close();
		if(conn != null)
			conn.close();
		
	}
	
	
	public void createFavSongs() {
		
		try {
			
			
		String sql = "CREATE TABLE SongList"
				+ " (title VARCHAR(50),"
				+ " singer VARCHAR(50),"
				+ " released INTEGER)";
		
		rs = init().createStatement().executeQuery(sql);
		System.out.println("create success!");
		
		}catch(SQLSyntaxErrorException e) {
			System.out.println("table already exists");
			return;
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<FavSongsDTO> listFavSongs() {
		
		List<FavSongsDTO> aList = new ArrayList<FavSongsDTO>();
		
		
		try {
			
			String sql = "SELECT * FROM SongList";
			rs = init().createStatement().executeQuery(sql);
			
			while(rs.next()) {
				FavSongsDTO dto = new FavSongsDTO(rs.getString("title"),rs.getString("singer"),rs.getInt("released"));
				aList.add(dto);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return aList;
	}

	public List<FavSongsDTO> searchFavSongs(String title) {
		List<FavSongsDTO> aList = new ArrayList<FavSongsDTO>();
		try {
			conn=init();
			String sql = "SELECT * FROM SongList WHERE upper(title) LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title.toUpperCase()+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FavSongsDTO dto = new FavSongsDTO(rs.getString("title"),rs.getString("singer"),rs.getInt("released"));
				aList.add(dto);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return aList;
	}

	public int insertFavSongs(FavSongsDTO dto) {
		int chk = -1;
		try {
			conn=init();
			String sql = "INSERT INTO SongList VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getSinger());
			pstmt.setInt(3, dto.getReleased());
			chk = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return chk;
	}

	// update
	public int updateFavSongs(int column,String originVal,String editVal) {
		int chk = -1;
		//노래이름검색 대소문자 insensitive, 모든 데이터 바꿈.
		try {
			conn=init();
			String sql = "UPDATE SongList SET ?=? WHERE upper(?) = upper(?)";
			pstmt = conn.prepareStatement(sql);
		
			// 컬럼을 키로, 원래값 예전값을 밸류로?
			if(column==1) {
				pstmt.setString(1, "song");
				pstmt.setString(2, editVal.toString());
				pstmt.setString(3, "song");
				pstmt.setString(4, originVal.toString());
			}else if(column==2) {
				pstmt.setString(1, "singer");
				pstmt.setString(2, editVal.toString());
				pstmt.setString(3, "singer");
				pstmt.setString(4, originVal.toString());
			}else if(column==3) {
				pstmt.setString(1, "released");
				pstmt.setInt(2, Integer.parseInt(editVal));
				pstmt.setString(3, "released");
				pstmt.setInt(4, Integer.parseInt(originVal));
			}else {
				System.out.println("잘못입력하셨습니다.");
			}
			
			chk=pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return chk;

	}

	// delete
	public int deleteFavSongs(String title) {
		int chk = -1;
		
		try {
			conn = init();
			String sql = "DELETE FROM SongList WHERE upper(title) = upper(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			chk = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return chk;

	}

}
