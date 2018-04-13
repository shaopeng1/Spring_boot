package com.example.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sp.entity.User;
import com.example.sp.mapper.UserMapper;
@RestController
public class UserController {
	@Autowired
	private UserMapper UserMapper;
	
	@RequestMapping("/user")
	public List<User> User(){
		List<User> list = UserMapper.userList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}
}
