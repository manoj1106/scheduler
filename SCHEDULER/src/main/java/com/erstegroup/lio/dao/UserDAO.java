package com.erstegroup.lio.dao;

import com.erstegroup.lio.db.model.UserLogin;

public interface UserDAO {

	public UserLogin getUserLoginDetailsByUsername(String userName);
	
}
