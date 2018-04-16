package com.example.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sp.entity.User;
import com.example.sp.mapper.UserMapper;

import util.RedisUtil;

@RestController
public class UserController {
	@Autowired
	private UserMapper UserMapper;
	
	static final Logger logger = LogManager.getLogger(UserController.class.getName());  

	@Value("${server.port}")
	String port;

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public Object getSession(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SessionId", request.getSession().getId());
		map.put("ServerPort", "服务端口号为 " + port);
		return map;
	}

	@RequestMapping(value = "/redis", method = RequestMethod.GET)
	public String redisTest() {
		System.out.println("====== 进行 Redis 缓存试验 ======");
		User user = new User();
		// 生成第一个用户的唯一标识符 UUID
		String u1_uuid = UUID.randomUUID().toString();
		// 去掉 UUID 的 - 符号
		String uuid1 = u1_uuid.substring(0, 8) + u1_uuid.substring(9, 13) + u1_uuid.substring(14, 18)
				+ u1_uuid.substring(19, 23) + u1_uuid.substring(24);
		user.setId(uuid1); 
		user.setAge(20);
		user.setName("张三");
		try {
			UserMapper.save(user);
		} catch (Exception e) {
			System.out.println("保存用户出现异常"+e);
		}
		// 第一次查询
		System.out.println(UserMapper.findById(user.getId()));
		// 通过缓存查询
		System.out.println(UserMapper.findById(user.getId()));
		System.out.println("====== 修改 Redis 缓存数据 ======");
		// 修改用户数据
		user.setAge(18);
		user.setName("李四");
		UserMapper.updateUser(user);
		System.out.println(UserMapper.findById(user.getId()));
		return "success";
	}

	@RequestMapping("/user")
	public List<User> User() {
		List<User> list = UserMapper.userList();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		RedisUtil util = new RedisUtil();
		util.set("cehsi", list.get(0));
		return list;
	}
}
