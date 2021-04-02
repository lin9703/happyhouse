package backend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// DBUtil 은 기능만 제공한다 => 멤버 변수 즉, State가 없다 => SingleTon
public class DBUtil {
	
	private static DBUtil util = new DBUtil();
	
	public static DBUtil getUtil() {
		return util;
	}
	
	// 1. 드라이버 로딩 - 매번 할 필요 없이 한 번만 하자(singleton)
	private DBUtil() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 2. Connection 확인 (언제나 동일)
	public Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, "ssafy", "ssafy");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 3. 자원 반납
	public void close(ResultSet rset, Statement pstmt, Connection con) {
		try {
			if(rset != null)
				rset.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
