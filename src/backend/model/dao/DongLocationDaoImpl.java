package backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import backend.dto.DongLocation;
import backend.util.DBUtil;

public class DongLocationDaoImpl implements DongLocationDao{
	
	private static DongLocationDao impl = null;
	private DBUtil util = DBUtil.getUtil();

	private DongLocationDaoImpl() {
	}
	
	public static DongLocationDao getDongLocationDao() {
		if(impl == null) {
			impl = new DongLocationDaoImpl();
		}
		
		return impl;
	}
	
	@Override
	public DongLocation getDongLocation(String dong) throws SQLException {
		DongLocation dongLocation = null;
		String sql = "select lng, lat from baseaddress where dong = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = util.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				String lng = rset.getString("lng");
				String lat = rset.getString("lat");

				dongLocation = new DongLocation(lng, lat);
			}
		} finally {
			util.close(rset, pstmt, con);
		}

		return dongLocation;
	}

}
