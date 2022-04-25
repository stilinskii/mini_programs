package login_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	
	//single tone
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	public Connection init() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin://@127.0.0.1:1521:xe";
		
		return DriverManager.getConnection(url,"hr","a1234");
		
	} 
	
	
	
	public List<MemberDTO> listMember(){
		return null;
		
	}
	
	
	
}
