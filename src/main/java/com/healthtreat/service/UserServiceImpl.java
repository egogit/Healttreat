package com.healthtreat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthtreat.domain.UserDTO;
import com.healthtreat.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean registerUser(UserDTO params) {
		int queryResult = 0;
		
		if (params.getId() == null) {
			queryResult = userMapper.registerUser(params);
		} else {
			queryResult = userMapper.updateUser(params);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public UserDTO selectUserInfo(Long id) {
		return userMapper.selectUserInfo(id);
	}

	@Override
	public boolean deleteUser(Long id) {
		int queryResult = 0;
		
		UserDTO user = userMapper.selectUserInfo(id);
		if (user != null) {
			queryResult = userMapper.deleteUser(id);
		}
		
		return (queryResult == 1) ? true : false;
	}

	@Override
	public UserDTO login(UserDTO params) {
		UserDTO user = userMapper.login(params);
		return user;
	}
}
