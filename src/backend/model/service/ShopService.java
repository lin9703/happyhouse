package backend.model.service;

import java.sql.SQLException;
import java.util.List;

import backend.dto.Shop;

public interface ShopService {
	List<Shop> getShopList(String gu, String dong) throws SQLException;

}
