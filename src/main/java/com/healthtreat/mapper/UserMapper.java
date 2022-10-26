package com.healthtreat.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.healthtreat.domain.UserDTO;

@Mapper
public interface UserMapper {
	public int registerUser(UserDTO params);
	public UserDTO selectUserInfo(Long id);
	public int updateUser(UserDTO params);
	public int deleteUser(Long id);
	public UserDTO login(UserDTO params);
}
