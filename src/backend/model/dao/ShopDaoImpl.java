package backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.dto.Shop;
import backend.dto.User;
import backend.util.DBUtil;

public class ShopDaoImpl implements ShopDao {
	
	private static ShopDao impl = null;
	private DBUtil util = DBUtil.getUtil();
	
	private ShopDaoImpl() {
	}
	
	public static ShopDao getShopImpl() {
		if(impl == null) {
			impl = new ShopDaoImpl();
		}
		
		return impl;
	}

	@Override
	public List<Shop> getShopList(String gu, String dong) throws SQLException {
		List<Shop> shops = new ArrayList<>();
		
		String sql = "select * from commercialarea where gu=? and dong=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = util.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gu);
			pstmt.setString(2, dong);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				String shopName = rset.getString("shopname");
				String lng = rset.getString("lng");
				String lat = rset.getString("lat");
				
				shops.add(new Shop(shopName, gu, dong, lng, lat));
			}
		} finally {
			util.close(rset, pstmt, con);
		}
		
		return shops;
	}

}
