package com.jk.mongodao;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserMongoDaoImpl implements UserMongoDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Map<String, Object> queryuser(Integer page, Integer rows, User user) {
		// TODO Auto-generated method stub
		Query query = new Query();
		long count = mongoTemplate.count(query, User.class);
		query.skip(page);
		query.limit(rows);
		List<User> list = mongoTemplate.find(query, User.class);
		Map<String, Object> map = new HashMap<>();
		map.put("total", count);
		map.put("rows", list);
		
		return map;
	}
	@Override
	public List<User> query() {
		
		return mongoTemplate.findAll(User.class);
	}
	@Override
	public void adduser(User user) {
		// TODO Auto-generated method stub
		mongoTemplate.save(user);
	}
	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class);
	}
	@Override
	public User querybyid(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
	}
}
