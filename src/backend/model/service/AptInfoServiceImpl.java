package backend.model.service;

import java.sql.SQLException;
import java.util.List;

import backend.dto.House;
import backend.model.dao.AptInfoDao;
import backend.model.dao.AptInfoDaoImpl;

public class AptInfoServiceImpl implements AptInfoService{
	private static AptInfoServiceImpl impl = new AptInfoServiceImpl();
	public static AptInfoServiceImpl getAptInfoServiceImpl() {
		return impl;
	}
	private AptInfoServiceImpl() {
		
	}
	
	AptInfoDao dao = AptInfoDaoImpl.getAptInfoImpl();
	
	// 1. 기본 검색(행정구역) - 법정동 추출
	@Override
	public List<House> getSearchList(String dong) throws SQLException {
		return dao.getSearchList(dong);
	}
	// 2. 아파트별, 실거래가별 검색
	@Override
	public List<House> getSearchTitleList(String searchTitle, String searchText) throws SQLException {
		return dao.getSearchTitleList(searchTitle, searchText);
	}
	
}
