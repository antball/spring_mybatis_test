package com.juren.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juren.dao.TUserMapper;
import com.juren.iservice.DemoService;
import com.juren.model.TUser;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Autowired
	TUserMapper userDao;

	public String sayHello(String name) {

		TUser user = userDao.selectByPrimaryKey(1);
		return "Hello " + user.getName();
	}

}
