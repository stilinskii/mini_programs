package login_system;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private CallableStatement cstmt;
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

		if (rs != null)
			rs.close();

		if (cstmt != null)
			cstmt.close();

		if (pstmt != null) {
			pstmt.close();
		}
	}

	// for join
	public void joinMember(String id, String pw) {

		try {
			cstmt = init().prepareCall("{call forjoin(?,?)}");
			cstmt.setString(1, id);
			cstmt.setString(2, pw);
			cstmt.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
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

	}

	// for id and password check
	public int loginChk(String id, String pw) {
		try {
			String sql = "SELECT * FROM memInfo where id = ?";
			pstmt = init().prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			String idInfo = rs.getString("id");
			String pwInfo = rs.getString("password");

			if (idInfo != null) {
				if (pwInfo.equals(pw)) {
					return 1;
				} else {
					return 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
		return 3;

	}

}
