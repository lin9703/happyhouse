package backend.model.service;

import java.sql.SQLException;
import java.util.List;

import backend.dto.Shop;
import backend.model.dao.ShopDao;
import backend.model.dao.ShopDaoImpl;

public class ShopServiceImpl implements ShopService {
	
	private static ShopService impl = null;
	private ShopDao shopDao = ShopDaoImpl.getShopImpl();
	
	private ShopServiceImpl() {
	}
	
	public static ShopService getShopDao() {
		if(impl == null) {
			impl = new ShopServiceImpl();
		}
		
		return impl;
	}
	
	@Override
	public List<Shop> getShopList(String gu, String dong) throws SQLException {
		return shopDao.getShopList(gu, dong);
	}

}
