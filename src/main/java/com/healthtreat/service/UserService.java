package com.healthtreat.service;

import com.healthtreat.domain.UserDTO;

public interface UserService {
	public boolean registerUser(UserDTO params);
	public UserDTO selectUserInfo(Long id);
	public boolean deleteUser(Long id);
	public UserDTO login(UserDTO params);
}
