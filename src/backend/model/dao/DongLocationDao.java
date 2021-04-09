package backend.model.dao;

import java.sql.SQLException;

import backend.dto.DongLocation;

public interface DongLocationDao {
	DongLocation getDongLocation(String dong) throws SQLException;
}
