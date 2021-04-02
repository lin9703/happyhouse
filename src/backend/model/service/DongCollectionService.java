package backend.model.service;

import java.sql.SQLException;
import java.util.List;

public interface DongCollectionService {
	// 1. guName(행정구역)으로부터 법정동을 가져오는 Class
	public List<String> getDongList(String guName) throws SQLException;
}
