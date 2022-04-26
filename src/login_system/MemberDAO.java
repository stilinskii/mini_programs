package login_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	// single tone
	private MemberDAO() {
	}

	private static MemberDAO dao = new MemberDAO();

	public static MemberDAO getInstance() {
		return dao;
	}


	public Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";

		return DriverManager.getConnection(url, "hr", "a1234");
	}
	public void exit() throws SQLException {
		if (conn != null)
			conn.close();
		
		if (stmt != null)
			stmt.close();
	}

	// save id and passwords to list collection
	public List<MemberDTO> listMember() {
		List<MemberDTO> aList = new ArrayList<MemberDTO>();
		try {
			String sql = "SELECT * FROM memInfo";
			rs = init().createStatement().executeQuery(sql);

			while (rs.next()) {
				MemberDTO dto = new MemberDTO(rs.getString("id"), rs.getString("password"));
				aList.add(dto);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				exit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return aList;

	}

	public boolean idChk(String userid){
		
		for(MemberDTO dto:dao.listMember()){
			if(dto.getId().equals(userid)) {
				return true;
			}}
		
				return false;

	}

	public boolean passwordChk(String password){

		for(MemberDTO dto:dao.listMember()){
			if(dto.getPassword().equals(password)) {
				return true;
			}
			
		}
			
					return false;

	}

}
