package backend.model.service;

import java.sql.SQLException;

import backend.dto.User;

public interface UserService {
	User login(String id, String password) throws SQLException;

	void siguUp(User user) throws SQLException;

	void update(User user) throws SQLException;

	void delete(String id) throws SQLException;
}
