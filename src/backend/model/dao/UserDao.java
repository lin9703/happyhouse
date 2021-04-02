package backend.model.dao;

import java.sql.SQLException;

import backend.dto.User;

public interface UserDao {
	User login(String id, String password) throws SQLException;
	
	void siguUp(User user) throws SQLException;

	void update(User user) throws SQLException;

	void delete(String id) throws SQLException;
}
