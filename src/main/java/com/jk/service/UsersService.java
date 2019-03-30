package com.jk.service;

import com.jk.model.User;

import java.util.Map;


public interface UsersService {

	Map<String, Object> queryuser(Integer page, Integer rows, User user);

	void adduser(User user);

	void deleteuser(String id);


	User querybyid(String id);

}
