package com.juren.test.service;

import com.juren.test.model.TUser;

import java.util.List;

public interface IUserService {
	
	TUser getUserById(int uid);

	List<TUser> getAllUser(int page);
}
