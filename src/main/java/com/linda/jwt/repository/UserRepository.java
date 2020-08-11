package com.linda.jwt.repository;

import com.linda.jwt.model.User;

public interface UserRepository {
	public void save(User user);
	public User login(User user);

}
