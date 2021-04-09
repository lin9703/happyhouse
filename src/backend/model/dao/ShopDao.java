package backend.model.dao;

import java.sql.SQLException;
import java.util.List;

import backend.dto.Shop;

public interface ShopDao {
	// dong 정보로 근처 shop list 가져오는 함수
	List<Shop> getShopList(String gu, String dong, String[] values) throws SQLException;
}
