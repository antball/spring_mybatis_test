package com.juren.test.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.juren.test.dao.TUserMapper;
import com.juren.test.model.TUser;
import com.juren.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

	@Autowired
	private TUserMapper userMapper;
	
	@Override
	public TUser getUserById(int uid) {
		return userMapper.selectByPrimaryKey(uid);
	}


	public List<TUser> getAllUser(int page){

		PageHelper.startPage(page, 1);
		List<TUser> us = userMapper.selectAll();

		PageInfo pages =new PageInfo(us);


		System.out.println("totals :" + ((Page) us).getTotal());

		return us;
	}
	
	

}
