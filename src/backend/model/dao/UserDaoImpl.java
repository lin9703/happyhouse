package backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.dto.User;
import backend.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private static UserDao impl = null;
	private DBUtil util = DBUtil.getUtil();
	
	public static UserDao getUserDao() {
		if (impl == null) {
			impl = new UserDaoImpl();
		}

		return impl;
	}

	private UserDaoImpl() {
	}

	@Override
	public User login(String id, String password) throws SQLException {
		User info = null;
		
		String sql = "select * from user where id=? and password=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = util.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String name = rset.getString("name");
				String address = rset.getString("address");
				String tel = rset.getString("tel");
				info = new User(id, password, name, address, tel);
			}
		} finally {
			util.close(rset, pstmt, con);
		}
		
		return info;
	}

}
