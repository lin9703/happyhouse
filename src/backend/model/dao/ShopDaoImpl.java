package backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import backend.dto.Shop;
import backend.util.DBUtil;

public class ShopDaoImpl implements ShopDao {

	private static ShopDao impl = null;
	private DBUtil util = DBUtil.getUtil();

	private ShopDaoImpl() {
	}

	public static ShopDao getShopImpl() {
		if (impl == null) {
			impl = new ShopDaoImpl();
		}

		return impl;
	}

	@Override
	public List<Shop> getShopList(String gu, String dong, String[] values) throws SQLException {
		List<Shop> shops = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from commercialarea where gu=? and dong=?");
		
		if(values != null && values.length != 0) {
			sql.append(" and codename1 in (");
			for(int i=0; i<values.length; i++) {
				sql.append("'").append(values[i]).append("',");
			}
			sql.delete(sql.length()-1, sql.length());
			sql.append(")");
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = util.getConnection();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, gu);
			pstmt.setString(2, dong);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				String shopName = rset.getString("shopname");
				String lng = rset.getString("lng").replaceAll("\"", "");
				String lat = rset.getString("lat").replaceAll("\"", "");
				String codeName = rset.getString("codename1");

				shops.add(new Shop(shopName, gu, dong, lng, lat, codeName));
			}
		} finally {
			util.close(rset, pstmt, con);
		}

		return shops;
	}

}
