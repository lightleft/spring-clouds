package com.xc.base.infrastructure.persistence.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.xc.base.infrastructure.persistence.model.User;

@Mapper
public interface UserMapper {
	@Insert("insert ignore into xc_user(name,age) values(#{name},#{age})")
	public Integer save(User user);
}
