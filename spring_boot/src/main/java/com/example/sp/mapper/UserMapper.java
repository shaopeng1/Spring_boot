package com.example.sp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.example.sp.entity.User;
@CacheConfig(cacheNames = "user")
public interface UserMapper {
	@Select("select * from user")
	List<User> userList();

	@CacheEvict(key="'user'")//清除user缓存
	@Insert("insert into user(id,age,name) values(#{id},#{age},#{name})")
	void save(User user);

	@Select("select * from user where id=#{id}")
	@Cacheable(key="'user_'+#id")//新增user_{id}缓存
	User findById(String id);
	
	@Update("update user set age = #{age} , name=#{name} where id = #{id}")
	@CacheEvict(key="'user_'+#id")//清除user缓存
	void updateUser(User user);
}
