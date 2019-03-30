package com.jk.mongodao;

import com.jk.model.User;

import java.util.List;
import java.util.Map;


public interface UserMongoDao {

	List<User> query();

	void adduser(User user);

	void remove(String id);

	Map<String, Object> queryuser(Integer page, Integer rows, User user);

	User querybyid(String id);

}
