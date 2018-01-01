package com.sbtdubbo.api.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbtdubbo.api.model.User;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectBySelective(User record);
}