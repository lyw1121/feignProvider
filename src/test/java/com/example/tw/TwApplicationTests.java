package com.example.tw;

import com.example.tw.dao.UserMapper;
import com.example.tw.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TwApplication.class)
public class TwApplicationTests {
	@Autowired
	UserMapper userMapper;

@Test
	public void testAdd() {
		User user = new User();
		user.setId("28");
		user.setDept("ke2");
		user.setName("yi2");
		user.setPassword("789");
		user.setPhone("fdf");
		user.setUname("666");
		userMapper.insert(user);
	}
	@Test
	public void testSelect() {
		List<User> listUser = userMapper.listUser();
		for (User user : listUser) {
			System.err.println(user.toString());
		}
	}
	@Test
	public void testDelete(){
		userMapper.delete("6");
	}
	@Test
	public void testUpdate(){
		User user = new User();
		user.setId("6");
		user.setUname("哈尔斯");
		user.setPhone("xixi");
		user.setName("hahah");
		user.setDept("jkjkjk");
		user.setPassword("我的");
		userMapper.update(user);

	}

}

