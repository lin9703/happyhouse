package backend.model.service;

import java.sql.SQLException;
import java.util.List;

import backend.dto.DongLocation;
import backend.dto.Shop;

public interface ShopInfoService {
	void setDongLocation(String dong) throws SQLException;

	void setShopList(String gu, String dong, String[] values) throws SQLException;
}
