package com.jk;

import com.jk.model.User;
import com.jk.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDomeApplicationTests {
	@Autowired
	private  UsersService usersService;
	@Test
	public void contextLoads() {
		User user = usersService.querybyid("5c938cb379f0f01a967d29b1");
		System.out.print(user.getId()+"--------------"+user.getMethodname());
	}

}
