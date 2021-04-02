package backend.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backend.dto.House;
import backend.util.DBUtil;

public class AptInfoDaoImpl implements AptInfoDao {

	// Singleton (기능만 제공하기 때문)
	private static AptInfoDaoImpl impl = new AptInfoDaoImpl();

	private AptInfoDaoImpl() {

	}

	public static AptInfoDaoImpl getAptInfoImpl() {
		return impl;
	}

	// DB 연결
	DBUtil util = DBUtil.getUtil();

	// 기본 검색(행정구역) - 법정동 추출
	@Override
	public List<House> getSearchList(String dong) throws SQLException {

		// 0. 객체 생성
		List<House> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 1. sql 문
		String sql = "select * from housedeal where dong=?";

		// 2. DB 연결
		try {
			con = util.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				String aptName = rset.getString("AptName");
				String dealAmount = rset.getString("dealAmount");
				dealAmount = dealAmount.replace(",", "").trim();
				int amount = Integer.parseInt(dealAmount);
				double area = rset.getDouble("area");
				int dealYear = rset.getInt("dealYear");
				int dealMonth = rset.getInt("dealMonth");
				int dealDay = rset.getInt("dealDay");

				list.add(new House(aptName, amount, area, dealYear, dealMonth, dealDay));
			}

		} finally {
			util.close(rset, pstmt, con);
		}

		return list;
	}

	// 2. 아파트별, 실거래가별 검색
	@Override
	public List<House> getSearchTitleList(String searchTitle, String searchText) throws SQLException {
		// 0. 객체 생성
		List<House> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = null;

		// 1. sql 문
		if (searchTitle.equals("apt")) {
			sql = "select * from housedeal where AptName like ?";

			// 2. DB 연결
			try {
				con = util.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%" + searchText + "%");
				rset = pstmt.executeQuery();

				while (rset.next()) {
					String aptName = rset.getString("AptName");
					String dealAmount = rset.getString("dealAmount");
					dealAmount = dealAmount.replace(",", "").trim();
					int amount = Integer.parseInt(dealAmount);
					double area = rset.getDouble("area");
					int dealYear = rset.getInt("dealYear");
					int dealMonth = rset.getInt("dealMonth");
					int dealDay = rset.getInt("dealDay");

					list.add(new House(aptName, amount, area, dealYear, dealMonth, dealDay));
				}

			} finally {
				util.close(rset, pstmt, con);
			}
		} else if (searchTitle.equals("deal")) {
			sql = "select * from housedeal";

			try {
				con = util.getConnection();
				pstmt = con.prepareStatement(sql);
				rset = pstmt.executeQuery();

				searchText = searchText.replace(",", "");
				int amount = Integer.parseInt(searchText);

				while (rset.next()) {
					String aptName = rset.getString("AptName");
					String dealAmount = rset.getString("dealAmount");
					dealAmount = dealAmount.replace(",", "").trim();
					int amount1 = Integer.parseInt(dealAmount);

					if (amount > amount1)
						continue;

					double area = rset.getDouble("area");
					int dealYear = rset.getInt("dealYear");
					int dealMonth = rset.getInt("dealMonth");
					int dealDay = rset.getInt("dealDay");

					list.add(new House(aptName, amount1, area, dealYear, dealMonth, dealDay));
				}

			} finally {
				util.close(rset, pstmt, con);
			}
		}
		return list;
	}

}
