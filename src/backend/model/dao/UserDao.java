package backend.model.dao;

import java.sql.SQLException;

import backend.dto.User;

public interface UserDao {
	User login(String id, String password) throws SQLException;
	
	//void siguUp(String id, String password, String name, String address, String tel);
}
