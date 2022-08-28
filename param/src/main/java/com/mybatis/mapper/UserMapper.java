package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    User getUserByUsername(String username);

    User checkLogin(String username, String password);

    User checkLoginByMap(Map<String, Object> map);

    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

    void insertUser(User user);
}
