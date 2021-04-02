package backend.model.service;

import java.sql.SQLException;

import backend.dto.User;

public interface UserService {
	User login(String id, String password) throws SQLException;
}
