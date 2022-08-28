package com.mybatis;

import com.mybatis.mapper.SelectMapper;
import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.getUserByUsername("jack");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user=mapper.checkLogin("jack","111111");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "root", "123456", 10, "F", "123@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","jack");
        map.put("password","111111");
        User user=mapper.checkLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByParam(){
        // SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        // UserMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // User user=mapper.checkLoginByParam("jack","111111");
        // System.out.println(user);
        // sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user=selectMapper.getUserById(5);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = selectMapper.getAllUser();
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = selectMapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(5);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getUserByLike("a");
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testDeleteManyUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        mapper.deleteManyUser("10,11");
        sqlSession.close();
    }

    @Test
    public void testGetUserList(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getUserList("t_user");
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testInsertUser2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = new User(null, "xxxx", "123456", 11, "M", "test@gmail.com");
        mapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }
}
