package backend.model.dao;

import java.sql.*;
import java.util.*;

import backend.util.DBUtil;

// 법정동을 가져오는 Class
public class DongCollectionImpl implements DongCollection {

	// singleton
	private static DongCollectionImpl dc = new DongCollectionImpl();
	private static Map<String, List<String>> guCollection = new HashMap<>();

	private DongCollectionImpl() {

	}

	public static DongCollectionImpl getDongCollection() {
		return dc;
	}

	// DB 객체 가져오기
	DBUtil util = DBUtil.getUtil();

	// 선택된 "구"(행정구역)으로부터 DB에 저장된 법정동을 구하는 function
	public List<String> getDongList(String guName) throws SQLException {
		if (guCollection.containsKey(guName)) {
			return guCollection.get(guName);
		}

		// 0. 필요 객체 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<String> list = new ArrayList<>();

		// 1. sql문 작성
		String sql = "select distinct dong from baseaddress where gugun =?";

		// 2. 연결
		try {
			con = util.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, guName);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String dong = rset.getString("dong");
				list.add(dong);
			}
		} finally {
			util.close(rset, pstmt, con);
		}
		Collections.sort(list);
		guCollection.put(guName, list);
		return list;
	}
}
