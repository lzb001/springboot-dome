package com.jk.service.Impl;

import com.jk.model.User;
import com.jk.mongodao.UserMongoDao;
import com.jk.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UserMongoDao userMongoDao;
	public Map<String, Object> queryuser(Integer page, Integer rows, User user) {
		// TODO Auto-generated method stub
		return userMongoDao.queryuser(page,rows,user);
	}

	public void adduser(User user) {
		// TODO Auto-generated method stub
		userMongoDao.adduser(user);
	}

	public void deleteuser(String id) {
		// TODO Auto-generated method stub
		userMongoDao.remove(id);
	}
	public User querybyid(String id) {
		// TODO Auto-generated method stub
		return userMongoDao.querybyid(id);
	}


	
	
}
