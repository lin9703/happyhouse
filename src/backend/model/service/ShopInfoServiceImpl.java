package backend.model.service;

import java.sql.SQLException;
import java.util.List;

import backend.dto.DongLocation;
import backend.dto.Shop;
import backend.model.dao.DongLocationDao;
import backend.model.dao.DongLocationDaoImpl;
import backend.model.dao.ShopDao;
import backend.model.dao.ShopDaoImpl;

public class ShopInfoServiceImpl implements ShopInfoService {
	
	private DongLocation dongLoc;
	private List<Shop> shopList;
	
	public ShopInfoServiceImpl(String gu, String dong) throws SQLException {
		setDongLocation(dong);
		setShopList(gu, dong);
	}
	
	@Override
	public void setDongLocation(String dong) throws SQLException {
		dongLoc = DongLocationDaoImpl.getDongLocationDao().getDongLocation(dong);
	}

	@Override
	public void setShopList(String gu, String dong) throws SQLException {
		shopList = ShopDaoImpl.getShopImpl().getShopList(gu, dong);
	}

}
