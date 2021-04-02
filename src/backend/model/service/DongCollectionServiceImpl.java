package backend.model.service;

import java.sql.SQLException;
import java.util.List;

import backend.model.dao.DongCollection;
import backend.model.dao.DongCollectionImpl;

//법정동을 가져오는 Class
public class DongCollectionServiceImpl implements DongCollectionService {
	
	private static DongCollectionServiceImpl dcs = new DongCollectionServiceImpl();
	private DongCollectionServiceImpl() {

	}
	public static DongCollectionServiceImpl getDongCollectionServiceImpl(){
		return dcs;
	}
	
	// DAO 연결
	DongCollection dc = DongCollectionImpl.getDongCollection();
	
	// DAO 로부터 Data를 가져온다
	@Override
	public List<String> getDongList(String guName) throws SQLException {
		return dc.getDongList(guName);
	}

}
