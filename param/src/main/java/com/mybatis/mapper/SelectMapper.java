package com.mybatis.mapper;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    Integer getCount();

    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    @MapKey("id")
    Map<String, Object> getAllUserToMap();

    List<User> getUserByLike(@Param("name") String name);

    void deleteManyUser(@Param("ids") String ids);

    List<User> getUserList(@Param("tablename") String tablename);

    void insertUser(User user);
}
