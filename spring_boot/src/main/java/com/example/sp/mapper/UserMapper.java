package com.example.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.sp.entity.User;

public interface UserMapper {
	@Select("select * from user")
	List<User> userList();
}
